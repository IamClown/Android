package com.example.zyj.testdatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button           createTable;
    private Button           addData;
    private Button           deleteData;
    private Button           updateData;
    private Button           selectData;
    private Button           insertData;
    //声明类
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化MyDatabaseHelper
        dbHelper = new MyDatabaseHelper(this, "Student.db", null, 2);
        //使用sql语句添加数据
        insertData=findViewById(R.id.btn_insert);
        insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into Student values (?,?,?,?)",new String[]{"5","201604623053","9500","陈涛"});
            }
        });
        //查询数据
        selectData = findViewById(R.id.btn_Select);
        selectData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Student", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String number = cursor.getString(cursor.getColumnIndex("number"));
                        Double tuition = cursor.getDouble(cursor.getColumnIndex("tuition"));
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        Log.d("MainActivity", "学号：" + number);
                        Log.d("MainActivity", "学费：" + tuition);
                        Log.d("MainActivity", "姓名：" + name);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
        //删除数据
        deleteData = findViewById(R.id.btn_Delete);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Student", "name=?", new String[]{"张英剑"});
            }
        });
        //更新数据
        updateData = findViewById(R.id.btn_Update);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("tuition", 5500);
                db.update("Student", values, "name=?", new String[]{"张英剑"});
            }
        });
        //添加数据
        addData = findViewById(R.id.btn_Add);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("number", "201604623052");
                values.put("tuition", 9500);
                values.put("name", "张英剑");
                //添加第一条数据
                db.insert("Student", null, values);
                values.clear();
                values.put("number", "201604623051");
                values.put("tuition", 9500);
                values.put("name", "刘杰");
                db.insert("Student", null, values);
                Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });
        //创建表
        createTable = findViewById(R.id.btn_Create);
        createTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用SQLiteOpenHelper方法
                dbHelper.getWritableDatabase();
            }
        });
    }
}
