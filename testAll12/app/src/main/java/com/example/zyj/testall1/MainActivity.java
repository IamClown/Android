package com.example.zyj.testall1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences        pref;
    private SharedPreferences.Editor editor;
    private EditText                 et_username;
    private EditText                 et_userpwd;
    private Button                   btn_login;
    private TextView                 register;
    private TextView                 server;
    private TextView                 tell;
    public  String                   return_name, return_pwd;
    private CheckBox ck_rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置背景
        getWindow().setBackgroundDrawableResource(R.mipmap.login_pic);
        //注册部分，先用shared Preference代替数据库
        //读取数据
        readDate();
        //初始化控件
        Initialization();
        //点击事件
        Clickevents();
        //保存数据

    }

    private void readDate() {
        SharedPreferences sharedPreferences = getSharedPreferences("info", Activity.MODE_PRIVATE);
        return_name = sharedPreferences.getString("userName", "");
        return_pwd = sharedPreferences.getString("userPwd", "");
    }

    private void Clickevents() {
        //给tell设置监听
        tell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:13653249071"));
                startActivity(intent);
            }
        });
        //server按钮设置监听
        server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        //给注册新用户按钮设置监听
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        //给登录按钮设置监听
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = et_username.getText().toString();
                String pwd = et_userpwd.getText().toString();
                if (name.equals("1920320688") && pwd.equals("5211314")) {
                    editor = pref.edit();
                    if (ck_rememberPass.isChecked()) {
                        editor.putBoolean("remember_password", true);
                        editor.putString("account", name);
                        editor.putString("password", pwd);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, control.class);
                    startActivity(intent);
                    finish();
                } else if (name.equals(return_name) && pwd.equals(return_pwd)) {
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, control.class);
                    startActivity(intent);
                    finish();
                } else if (name.equals("") || pwd.equals("")) {
                    Toast.makeText(MainActivity.this, "用户名或者是密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Initialization() {
        et_username = findViewById(R.id.userName);
        et_userpwd = findViewById(R.id.userPwd);
        btn_login = findViewById(R.id.login);
        register = findViewById(R.id.tv_register);
        server = findViewById(R.id.tv_server);
        tell = findViewById(R.id.tv_tell);
        pref= PreferenceManager.getDefaultSharedPreferences(this);
        ck_rememberPass = findViewById(R.id.checkBox);
        Boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {
            String account = pref.getString("acount", "");
            String password = pref.getString("password", "");
            et_userpwd.setText(account);
            et_userpwd.setText(password);
            ck_rememberPass.setChecked(true);
        }
        if (ck_rememberPass.isChecked()) {
            String pwd = et_username.getText().toString();
            pwd = return_pwd;
        }
        //menu=findViewById(R.id.tv_menu);
    }


  /*  @Override
    public void onOptionsMenuClosed(Menu menu) {
        Toast.makeText(MainActivity.this,"菜单被关闭了",Toast.LENGTH_SHORT).show();
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getGroupId()) {
            case R.id.finish_item:
                Toast.makeText(MainActivity.this, "即将退出", Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/

}
