package com.example.zyj.demo001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    //成员变量：字符串数组，用于保存下拉菜单列表项
    public static final String[] COUNTRIES={
            "tianjin","tianmao","天津小吃","天天向上","天津现代职业技术学院","美丽天津"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取自动完成文本框
        final AutoCompleteTextView autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        //创建一个ArrayAdapter适配器，显示列表项
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,COUNTRIES);
        //自动完成文本框与适配器关联
        autoCompleteTextView.setAdapter(adapter);
        //获取按钮，并添加单击事件监听器
        Button button=(Button) findViewById(R.id.btn_search);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //通过消息提示框，显示自动完成文本框中输入的内容
                Toast.makeText(MainActivity.this,autoCompleteTextView.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
