package com.example.zyj.broadcastbestpractice;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //先获取数据
        EditText RegisterName = findViewById(R.id.et_registerName);
        EditText RegisterPwd = findViewById(R.id.et_registerPwd);
        Button register = findViewById(R.id.button);
        final String RN = RegisterName.getText().toString();
        final String RP = RegisterPwd.getText().toString();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MODE_PRIVATE。默认操作模式，直接在把第二个参数写0
                // 就是默认使用这种操作模式，这种模式表示只有当前的应用程序才可以对当前这个SharedPreferences
                // 文件进行读写。
                //得到SharedPreferences对象
                SharedPreferences sp = getSharedPreferences("info", MODE_PRIVATE);
                //调用SharedPreferences对象的edit()方法来获取一个SharedPreferences.Editor对象。
                SharedPreferences.Editor editor = sp.edit();
                //向SharedPreferences.Editor对象中添加数据。数据一键值对的方式存储
                editor.putString("name", RN);
                editor.putString("pwd", RP);
                //提交数据
                editor.apply();
            }
        });

    }

}
