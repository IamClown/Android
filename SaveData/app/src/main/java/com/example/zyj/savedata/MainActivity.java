package com.example.zyj.savedata;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private EditText edt_read;
    private Button   button;
    private Button   button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit);
        edt_read = findViewById(R.id.read);
        button = findViewById(R.id.btn_read);
        button1 = findViewById(R.id.btn_write);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取文本框中输入的内容
                String inputText = editText.getText().toString();
                //调用save方法把输入的内容存储到文件中
                save(inputText);
                Toast.makeText(MainActivity.this, "写入成功", Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //接收数据的返回值
                String readText = load();
                edt_read.setText(readText);
                edt_read.setSelection(readText.length());
                Toast.makeText(MainActivity.this, "读取成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String load() {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return builder.toString();
    }

    //在程序被回收之前，将数据存储起来
 /*   @Override
    protected void onDestroy() {
        super.onDestroy();
        //获取文本框中输入的内容
        String inputText = editText.getText().toString();
        //调用save方法把输入的内容存储到文件中
        save(inputText);
    }*/

    private void save(String inputText) {
        //声明文件输出流
        FileOutputStream out = null;
        //声明缓冲流存数据
        BufferedWriter writer = null;
        try {
            //openFileOutput中有两个参数，第一个是文件名称，第二个是文件的操作模式
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write (inputText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
