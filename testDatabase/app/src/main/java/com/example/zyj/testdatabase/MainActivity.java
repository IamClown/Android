package com.example.zyj.testdatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.TooManyListenersException;

public class MainActivity extends AppCompatActivity {
    //创建MyDatabaseHelper对象
    private MyDatabaseHelper dbHelper;
    private Button           insertTable;
    private Button           deleteTable;
    private Button           updateTable;
    private Button           selectTable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例对象
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        //创建数据库
        Button createTable = findViewById(R.id.btn_create);
        createTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });
        //我们刚才升级的数据库，注意版本号
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        //查询数据
        selectTable = findViewById(R.id.btn_select);
        selectTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //查询所有数据，将查询到的数据全都放在cursor中
                Cursor cursor = db.query("Book", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        //遍历cursor对象，取出数据
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        Double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("MainActivity", "书名:" + name);
                        Log.d("MainActivity", "作者:" + author);
                        Log.d("MainActivity", "页数:" + pages);
                        Log.d("MainActivity", "单价:" + price);
                    } while (cursor.moveToNext());
                }
                //关闭cursor
                cursor.close();
            }
        });
        //删除数据
        deleteTable = findViewById(R.id.btn_delete);
        deleteTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book", "name=?", new String[]{"shuiHu"});
                Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
            }
        });
        //更新数据
        updateTable = findViewById(R.id.btn_update);
        updateTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("author", "张英剑");
                db.update("Book", values, "name=?", new String[]{"xiYouJi"});

            }
        });
        insertTable = findViewById(R.id.btn_insert);
        insertTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("name", "xiYouJi");
                values.put("author", "Dan Brown");
                values.put("pages", "456");
                values.put("price", "16.97");
                //插入第一条数据
                db.insert("Book", null, values);
                values.put("name", "shuiHu");
                values.put("author", "Dan Brown");
                values.put("pages", "456");
                values.put("price", "16.97");
                db.insert("Book", null, values);
                Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
