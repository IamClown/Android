package com.example.zyj.testdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    //定义sql语句
    private static final String CREATE_STUDENT = "create table Student(" + "id integer primary "
            + "key " + "autoincrement," + "number text," + "tuition real," + "name text)";
    //声明上下文
    private Context mContext;

    //声明构造器
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                            int version) {
        super(context, name, null, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STUDENT);
        Toast.makeText(mContext, "创建成功", Toast.LENGTH_SHORT).show();
    }

    //升级数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //如果数据库中有这个表，我们先删除，在创建
        db.execSQL("drop table if exists Student");
        //调用onCreate方法，创建表
        onCreate(db);
    }
}
