package com.example.zyj.testactivitytime;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by zyj on 2018/4/15.
 */

public class testActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d("testActivity",getClass().getSimpleName());
        ActivityCollector.addActivity(testActivity.this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    ActivityCollector.removeActivity(this);
    }
}
