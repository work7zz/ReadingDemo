package com.example.readingdemo.pages;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.readingdemo.R;
import com.example.readingdemo.net.GetApi;
import com.example.readingdemo.net.api.DictoraryApi;
import com.example.readingdemo.something.Translation;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Random;
import io.reactivex.Observable;
import org.reactivestreams.Subscription;


/**
* Created by yuzhiqi on 2019/3/6
*
* @author 于治麒 yuzhiqi@bytedance.com
*/

public class TestNetActivity extends AppCompatActivity {

    private DictoraryApi mDictionaryApi;
    private EditText inputEditText;
    private TextView output;

    private int[] colors = {Color.RED,Color.BLUE,Color.YELLOW,Color.GRAY,Color.GREEN};

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_net);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar action = getSupportActionBar();
        if (action != null) {
            action.setDisplayHomeAsUpEnabled(true);
        }

        mDictionaryApi = GetApi.getDictionaryApi();
        inputEditText = findViewById(R.id.input_editText);
        output = findViewById(R.id.output);
        final Button translate = findViewById(R.id.translate_button);
        final Random random = new Random();

        Integer[] intArray = {1, 2, 3, 4, 5};
        Observable.fromArray(intArray).map(new Function<Integer, String>() {
            @Override
            public String apply(final Integer integer) throws Exception {
                return "number" + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(final String s) throws Exception {
                Log.d("print:", s);
            }
        });

        /**
         * 这个干嘛的
         */
        Disposable disposable = Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(final CompletableEmitter emitter) throws Exception {

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Subscription subscription;

        translate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                String word = inputEditText.getText().toString();
                Observable<Translation> call = mDictionaryApi.getDictorary(word + " .");
                call.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Translation>() {
                            @Override
                            public void onSubscribe(final Disposable d) {

                            }

                            @Override
                            public void onNext(final Translation translation) {
                                Log.d("解析后数据", translation.getContent());
                                output.setBackgroundColor(colors[random.nextInt(5)]);
                                output.setText(translation.getResult());
                                Toast.makeText(TestNetActivity.this,"done",Toast.LENGTH_SHORT).show();
                                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                            }

                            @Override
                            public void onError(final Throwable e) {

                            }

                            @Override
                            public void onComplete() {
                                Toast.makeText(TestNetActivity.this, "done", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });

        /**
         * 单独使用Retrofit，使用Callback
         */
        /*call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(final Call<Translation> call, final Response<Translation> response) {

                Log.d("Json数据",response.toString());

                response.body().show();
                TextView textView = findViewById(R.id.net_request__text_View);
                textView.setText(response.body().getContent());
            }

            @Override
            public void onFailure(final Call<Translation> call, final Throwable t) {
                Log.d("Json数据",t.getLocalizedMessage());
            }
        });*/


    }
}
