package com.example.readingdemo.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.example.readingdemo.bookmall.AnotherBookMallActivity;
import com.example.readingdemo.pages.TestNetActivity;
import com.example.readingdemo.pages.DisplayItemActivity;
import com.example.readingdemo.R;
import com.example.readingdemo.bookmall.BookMallActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.enter_book_mall_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(new Intent(SplashActivity.this, BookMallActivity.class));
            }
        });

        findViewById(R.id.book_introduce_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(new Intent(SplashActivity.this, DisplayItemActivity.class));
            }
        });

        findViewById(R.id.enter_book_mall1_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(new Intent(SplashActivity.this, AnotherBookMallActivity.class));
            }
        });

        findViewById(R.id.test_net_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(new Intent(SplashActivity.this, TestNetActivity.class));
            }
        });
    }
}
