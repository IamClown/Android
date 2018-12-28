package com.example.zyj.testdatabase1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    private Button           createTable;
    private Button           insert;
    private Button           delete;
    private Button           update;
    private Button           select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //通过构造函数将数据库的名字指定为BookStore.db，版本号为1
        dbHelper = new MyDatabaseHelper(this, "BookInfo.db", null, 2);
        createTable = findViewById(R.id.btn_create);
        createTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用getWritableDatabase方法，注意该版本号
                dbHelper.getWritableDatabase();
            }
        });
        insert = findViewById(R.id.btn_insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", "西游记");
                values.put("author", "吴承恩");
                values.put("pages", 456);
                values.put("price", 19.56);
                db.insert("Book", null, values);
                values.clear();
                Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
