package com.coolweatherpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.coolweatherpractice.util.SupportMultipleScreensUtil;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //第一次
        View rootview = findViewById(android.R.id.content);
        SupportMultipleScreensUtil.scale(rootview);


    }
}
