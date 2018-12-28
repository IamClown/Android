package com.example.zyj.providertest;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button insert;
    private Button delete;
    private Button update;
    private Button select;
    private String newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert = (Button) findViewById(R.id.btn_add);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //添加数据
                Uri uri = Uri.parse("content://com.example.zyj.testdatabase.provider/book");
                ContentValues values = new ContentValues();
                values.put("name", "Kings");
                values.put("author", "张明浩");
                values.put("price", 22.85);
                values.put("pages", 1024);
                Uri newUri = getContentResolver().insert(uri, values);
            }
        });
        select = (Button) findViewById(R.id.btn_query);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //查询数据
                Uri uri = Uri.parse("content://com.example.zyj.testdatabase.provider/book");
                Cursor cursor = getContentResolver().query(uri, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("MainActivity", "onClick: name:" + name);
                        Log.d("MainActivity", "onClick: author:" + author);
                        Log.d("MainActivity", "onClick: pages:" + pages);
                        Log.d("MainActivity", "onClick: price:" + price);
                    }
                }
            }
        });
    }
}
