package com.example.zyj.androidcode05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    private Button button;
    private EditText name,userName,userPwd;
    private ArrayList<String> data;
    private ArrayList<String> Show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        name=findViewById(R.id.etName);
        userName=findViewById(R.id.etUName);
        userPwd=findViewById(R.id.etPwd);
        Intent intent=getIntent();
        ArrayList<String> data=intent.getStringArrayListExtra("data_pass");
        name.setText(data.get(0));
        userName.setText(data.get(1));
        userPwd.setText(data.get(2));
        Log.d("FirstActivity","张英剑");
    }
}
