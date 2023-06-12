package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseExample extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Question.db";
    private static final int DATABASE_VERSION = 1;
    private Context mContext;
    private SQLiteDatabase mdataBase;

    public DatabaseExample( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
        mdataBase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
