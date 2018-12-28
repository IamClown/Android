package com.example.zyj.testall1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class control extends AppCompatActivity {
    //成员变量：字符串数组，用于保存下拉菜单列表项
    private static final String[] Countries={"刘杰","杨磊","谷文","张英剑","兰福全","王世成","彭博"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        //不会数据库，声明一个数组，存放数据
        Initialization();
    }

    private void Initialization() {
        final AutoCompleteTextView autoCompleteTextView=findViewById(R.id.seach);
        //创建一个adapter适配器,显示列表项
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Countries);
        autoCompleteTextView.setAdapter(adapter);
    }
}
