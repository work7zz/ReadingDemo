package com.example.readingdemo.pages;

import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.example.readingdemo.R;
import com.example.readingdemo.bookmall.AnotherBookMallActivity;
import com.example.readingdemo.testDialog.AutoLockScreenTimeAdapter;
import com.example.readingdemo.testDialog.SelectAutoLockScreenTimeDialog;
import com.example.readingdemo.testDialog.SelectAutoLockScreenTimeDialog.SetAutoLockScreenTimeListener;
import java.util.Arrays;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        ActionBar ac = getSupportActionBar();
        ac.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int bookId = bundle.getInt("ID");
        Toast.makeText(this,"book"+bookId,Toast.LENGTH_SHORT).show();
        TextView textView = findViewById(R.id.book_id_textView);
        textView.setText("book" + bookId);
        int iii = 0;
        int bbb = 90;


        // 2147483647

        final SelectAutoLockScreenTimeDialog a = new SelectAutoLockScreenTimeDialog(this,
                new SetAutoLockScreenTimeListener() {
                    @Override
                    public void setAutoLockScreenTime(String autoLockScreenTime) {
                        ((TextView)findViewById(R.id.switch_text)).setText(autoLockScreenTime);
                    }
                });

        Switch switch1 = findViewById(R.id.switch1);
        final TextView switchText = findViewById(R.id.switch_text);
        final TextView selectTime = findViewById(R.id.select_dialog);
        //final View selectTime1 = findViewById(R.id.select_automatic_lock_screen_time_layout);
        switch1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
                if(buttonView.isChecked()){

                    a.show();
                    switchText.setText("弹窗"+" 把时间显示出来");
                    // selectTime1.setVisibility(View.VISIBLE);
                    selectTime.setText("5/15/30/60min");
                    Toast.makeText(buttonView.getContext(),"弹出dialog",Toast.LENGTH_SHORT).show();


                }else{
                    switchText.setText("回到初始状态");
                    //selectTime1.setVisibility(View.GONE);
                }
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }

}
