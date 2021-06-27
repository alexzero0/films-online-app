package com.example.myapptwo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBfilms extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "dbFilms";
    public static final String TABLE_CONTACTS = "favFilm";

    public static final String KEY_ID = "_id";
    public static final String KEY_USERS = "myID";
    public static final String KEY_POSITION = "position";

    public static final String FILM_NAME = "filmname";
    public static final String FILM_STILE = "filmstile";
    public static final String FILM_YEAR = "filmyear";
    public static final String FILM_IMAGE = "bitimage";
    public static final String FILM_BIT64 = "bit64";




    public DBfilms(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CONTACTS + "(" + KEY_ID
                + " integer primary key,"+ KEY_USERS + " text,"
                + KEY_POSITION + " integer," + FILM_NAME + " text,"
                + FILM_STILE + " text," + FILM_YEAR + " text,"
                + FILM_IMAGE + " integer," + FILM_BIT64 + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CONTACTS);
        onCreate(db);
    }
}
