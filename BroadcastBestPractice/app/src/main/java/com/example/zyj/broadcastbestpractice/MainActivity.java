package com.example.zyj.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.InflaterInputStream;

public class MainActivity extends AppCompatActivity {
    //初始化控件
    private EditText userName, userPwd;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initControl();
        //事件
        initEvent();

    }

    private void initEvent() {
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //读取SharedPreferences中的数据
                //先得到对象
                SharedPreferences pref = getSharedPreferences("info", MODE_PRIVATE);
                String ReturnName = pref.getString("name", "");
                String ReturnPwd = pref.getString("pwd", "");
                String name = userName.getText().toString();
                String pwd = userPwd.getText().toString();
                if (name.equals("admin") && pwd.equals("123456")) {
                    Intent intent = new Intent(MainActivity.this, Control.class);
                    startActivity(intent);
                    finish();
                } else if (name.equals(ReturnName) && pwd.equals(ReturnPwd)) {
                    Intent intent = new Intent(MainActivity.this, Control.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "登录失败！请注册", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                    finish();
                }
            }
        });
    }

    private void initControl() {
        userName = findViewById(R.id.et_username);
        userPwd = findViewById(R.id.et_userpwd);
        Login = findViewById(R.id.btn_login);
    }
}
