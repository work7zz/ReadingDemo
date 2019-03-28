package com.example.readingdemo.testDialog;


import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.readingdemo.R;
import java.util.List;


/**
 * Created by yuzhiqi on 2019/03/12
 *
 * @author 于治麒 yuzhiqi@bytedance.com
 */
public class AutoLockScreenTimeAdapter extends BaseAdapter {

    private final List<String> AutoLockScreenTime;

    public AutoLockScreenTimeAdapter(final List<String> autoLockScreenTime) {
        AutoLockScreenTime = autoLockScreenTime;
    }

    public List<String> getAutoLockScreenTime(){
        return AutoLockScreenTime;
    }
    @Override
    public int getCount() {
        return AutoLockScreenTime.size();
    }

    @Override
    public String getItem(final int position) {
        return AutoLockScreenTime.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater mLayoutInflater = LayoutInflater.from(parent.getContext());
        convertView = mLayoutInflater.inflate(R.layout.auto_lock_screen_time_button,parent,false);
        ((TextView)convertView.findViewById(R.id.button_auto_lock_screen_time)).setText(AutoLockScreenTime.get(position));
        return convertView;
    }
}

