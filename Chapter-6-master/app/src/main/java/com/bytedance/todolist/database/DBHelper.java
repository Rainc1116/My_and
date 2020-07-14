package com.bytedance.todolist.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dao.db";
    public static final int DATABASE_VERSION;

    static {
        DATABASE_VERSION = 1;
    }

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    private static final String DATABASE_CREATE = "CREATE TABLE contacts (_id integer primary key autoincrement,username text,password text)";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_NAME);
        onCreate(db);
    }

}
