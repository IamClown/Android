package com.example.zyj.androidcode05;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //声明变量
    private Button Register,Cancle;
    private EditText UserName,UserPwd,RealName;
    private RadioButton Male,Female;
    private Spinner RealAge;
    private RadioGroup Sex;
    String female,male,realName,userPwd,userName,sex;
    private ArrayList<String> ifo=new ArrayList<>();
    private ArrayList<String> data=new ArrayList<>();
    //声明一个int，作为初始的索引
    private int a = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
        getdata();
    }
    public void InitView(){
        //初始化控件
        RealAge=findViewById(R.id.spRealAge);
        Female=findViewById(R.id.rdoFemale);
        female=Female.getText().toString();
        Male=findViewById(R.id.rdoMale);
        male=Male.getText().toString();
        RealName=findViewById(R.id.etRealName);
        realName=RealName.getText().toString();
        UserPwd=findViewById(R.id.etUserPwd);
        userPwd=UserPwd.getText().toString();
        UserName=findViewById(R.id.etUserName);
        userName=UserName.getText().toString();
        Register=findViewById(R.id.btnRegister);
        Cancle=findViewById(R.id.btnCancel);
    }

    //重写onCreateOptionsMenu方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //通过选择id给按钮添加事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getGroupId()){
            case R.id.Add_item:
                Toast.makeText(MainActivity.this,"你点击了添加按钮",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Remove_item:
                Toast.makeText(MainActivity.this,"你点击了移除按钮",Toast.LENGTH_SHORT).show();
                break;
                default:
        }
        return true;
    }



    public void getdata(){


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.add(userName);
                data.add(realName);
                data.add(userPwd);
                Intent intent = new Intent(MainActivity.this,FirstActivity.class);
                intent.putStringArrayListExtra("data_pass",data);
                Log.d("MainActivity","s"+data.size());
                startActivity(intent);

            }
        });

        Cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* String [] data={female,male,realName,userPwd,userName};
                Intent intent = new Intent(MainActivity.this,FirstActivity.class);
                intent.putExtra("data_pass",data);
                startActivity(intent);*/
                //Toast.makeText(MainActivity.this,"取消成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 1:
                if (resultCode==RESULT_OK){
                    String returnData=data.getStringExtra("data_return");
                    Log.d("MainActivity",returnData);
                }
                break;
            default:
        }
    }
}
