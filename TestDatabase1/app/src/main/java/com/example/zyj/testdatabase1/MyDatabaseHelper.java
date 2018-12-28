package com.example.zyj.testdatabase1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    //声明字符串，存储sql语句
    public static final String CREATE_BOOK = "create table Book(" + "id integer primary key " +
            "autoincrement," + "author text," + "pages integer," + "name text)";

    //在创建一个表
   /* public static final String CREATE_INFO = "create table Info(" + "id integer primary key " +
            "autoincrement," + "author text," + "pages integer," + "name text)";*/
    //声明上下文
    private Context mContext;

    //声明构造器
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                            int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        //db.execSQL(CREATE_INFO);
        //提示
        Toast.makeText(mContext, "成功创建表", Toast.LENGTH_SHORT).show();
    }

    //这个方法用来升级数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //如果数据库中有这两个表，我们先删除这两个表，然后在创建
        //db.execSQL(CREATE_INFO);
        db.execSQL("drop table if exists Book");
        //调用onCreate方法，创建数据库
        onCreate(db);
    }
}
