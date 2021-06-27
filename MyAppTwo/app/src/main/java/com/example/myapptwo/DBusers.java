package com.example.myapptwo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBusers extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "dbUsers";
    public static final String TABLE_CONTACTS = "auth";

    public static final String KEY_ID = "_id";
    public static final String KEY_USERS = "myID";
    public static final String KEY_NAME = "login";
    public static final String KEY_PASS = "password";



    public DBusers(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CONTACTS + "(" + KEY_ID
                + " integer primary key,"+ KEY_USERS + " text,"
                + KEY_NAME + " text," + KEY_PASS + " text" + ")");

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USERS, "1337");
        contentValues.put(KEY_NAME, "alex");
        contentValues.put(KEY_PASS, "qq");

        db.insert(TABLE_CONTACTS,null,contentValues);
        contentValues.clear();

        contentValues.put(KEY_USERS, "5352");
        contentValues.put(KEY_NAME, "joke");
        contentValues.put(KEY_PASS, "ww");
        db.insert(TABLE_CONTACTS,null,contentValues);

        //надо ли закрывать базу данных ?
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CONTACTS);
        onCreate(db);
    }
}
