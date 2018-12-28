package com.example.zyj.testall1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText register_username;
    private EditText register_userpwd;
    private Button btn_submit;
/*
    private String username,userpwd;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //设置背景
        getWindow().setBackgroundDrawableResource(R.mipmap.register_pic);
        //初始化控件
        initDate();
        //点击事件
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //存数据
                SharedPreferences sp = getSharedPreferences("info", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                String username = register_username.getText().toString();
                String userpwd = register_userpwd.getText().toString();
                editor.putString("userName",username);
                editor.putString("userPwd",userpwd);
                editor.apply();
                Log.d("RegisterActivity",username);
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }



    private void initDate() {
        btn_submit=findViewById(R.id.btn_register);
        register_username =findViewById(R.id.register_name);
        register_userpwd=findViewById(R.id.register_pwd);

    }


}
