package com.example.zyj.testlitepal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button create;
    private Button insert;
    private Button select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create = (Button) findViewById(R.id.btn_createDatabase);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });
        insert=(Button) findViewById(R.id.btn_insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setId(1);
                book.setAuthor("张英剑");
                book.setName("恋爱守则");
                book.setPrice(521);
                book.setPages(500);
                book.setPress("609");
                book.save();
            }
        });
        select=(Button)findViewById(R.id.btn_select);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = DataSupport.findAll(Book.class);
                for (Book book :books){
                    Log.d("MainActivity", "book id is "+book.getId());
                    Log.d("MainActivity", "book name is "+book.getName());
                    Log.d("MainActivity", "book author is "+book.getAuthor());
                    Log.d("MainActivity", "book pages is"+book.getPages());
                    Log.d("MainActivity", "book price is "+book.getPrice());
                    Log.d("MainActivity", "book press is "+book.getPress());
                    Intent intent = new Intent();

                }
            }
        });
    }
}
