package com.example.zyj.testdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    //把我们对数据库的操作，写成字符串
    public static final String CREATE_BOOK     = "create table book(" + "id integer primary key "
            + "autoincrement," + "author text," + "price real," + "pages integer," + "name text)";
    public static final String CREATE_CATEGORY = "create table Category(" + "id integer primary "
            + "key autoincrement," + "category_name text," + "category_code integer)";
    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                            int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //执行对数据库的操作
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        //跨程序访问时我们不能使用Toast
        //Toast.makeText(mContext, "Create success", Toast.LENGTH_SHORT).show();
    }

    //这个方法用来升级数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //如果发现数据库中有这两个表，我们就先把他们删掉，然后在调用onUpgrade方法，重新创建
        //升级数据库的时候，一定要把版本号改掉，比之前大就行了
        db.execSQL("drop table if exists book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
}
