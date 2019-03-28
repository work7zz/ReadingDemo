package com.example.readingdemo.testDialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.example.readingdemo.R;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yuzhiqi on 2019/03/12
 *
 * @author 于治麒 yuzhiqi@bytedance.com
 */
public class SelectAutoLockScreenTimeDialog extends Dialog {

    private ListView mListView;
    private final AutoLockScreenTimeAdapter mAutoLockScreenTimeAdapter;
    private final List<String> autoLockScreenTimeButtonString;
    private SetAutoLockScreenTimeListener mSetAutoLockScreenTimeListener;
    private int automaticLockScreenTime;
    private boolean switchState;
    //private View selectAutomaticLockScreenTimeLayout;

    public SelectAutoLockScreenTimeDialog(Activity context,SetAutoLockScreenTimeListener mSetAutoLockScreenTimeListener){
        super(context, R.style.ReportErrorDialog);
        this.mSetAutoLockScreenTimeListener = mSetAutoLockScreenTimeListener;
        autoLockScreenTimeButtonString = initAutomaticLockScreenTimeButton();
        mAutoLockScreenTimeAdapter = new AutoLockScreenTimeAdapter(autoLockScreenTimeButtonString);
        setOwnerActivity(context);
        setContentView(R.layout.dialog_reader_menu_select_time_test);
        setLayoutParams();

    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button bt = this.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(v.getContext(),"click",Toast.LENGTH_SHORT).show();
            }
        });

        mListView = findViewById(R.id.list_view_automatic_lock_screen_time);
        mListView.setAdapter(mAutoLockScreenTimeAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(),"click",Toast.LENGTH_SHORT).show();
                mSetAutoLockScreenTimeListener.setAutoLockScreenTime(autoLockScreenTimeButtonString.get(position));

            }
        });

        //this.setCanceledOnTouchOutside(false);
        //selectAutomaticLockScreenTimeLayout = findViewById(R.id.dialog_select_automatic_lock_screen_time);
        //initSelectAutoLockScreenTime();

    }

    private void initSelectAutoLockScreenTime() {

//        selectAutomaticLockScreenTimeLayout.findViewById(R.id.btn_never_lock).setOnClickListener(setLockScreenTimeClickListener());
//        selectAutomaticLockScreenTimeLayout.findViewById(R.id.btn_fifteen_minutes).setOnClickListener(setLockScreenTimeClickListener());
//        selectAutomaticLockScreenTimeLayout.findViewById(R.id.btn_thirty_minutes).setOnClickListener(setLockScreenTimeClickListener());
//        selectAutomaticLockScreenTimeLayout.findViewById(R.id.btn_sixty_minutes).setOnClickListener(setLockScreenTimeClickListener());
    }

    public interface SetAutoLockScreenTimeListener{
        void setAutoLockScreenTime(String autoLockScreenTime);
    }

//    private View.OnClickListener setLockScreenTimeClickListener() {
//        return new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(),((Button)view).getText().toString() + "设置成功",Toast.LENGTH_SHORT).show();
//                ContextUtils.safeDismiss(SelectAutoLockScreenTimeDialog.this);
//            }
//        };
//    }

    private void setLayoutParams() {
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(layoutParams);
    }

    private List<String> initAutomaticLockScreenTimeButton(){
        return Arrays.asList(this.getContext().getResources().getStringArray(R.array.time));
    }
}

