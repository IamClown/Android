package com.example.zyj.testspinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    private TextView tv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        tv_show=findViewById(R.id.show);
        //接受数据
        Intent intent=getIntent();
        tv_show.setText("您选择的课程是"+intent.getStringExtra("data_pass"));
    }
}
