package com.example.myapptwo;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.myapptwo.ui.home.fragment.BlankFragment;

import java.util.List;

public class MyDialogFragment extends AppCompatDialogFragment {

    private int position;
    private int gPos = -1;
    private int gWhc = -1;
    private List<Film> gData;
    DBfilms dbFilms;

    public MyDialogFragment(int psn, List<Film> gData)
    {
        position = psn;
        this.gData = gData;

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] catNamesArray = {"информация", "в избранное", "отмена"};
        //"удалить", "отмена"//"информация", "в избранное", "отмена"

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        dbFilms = new DBfilms(getContext());

        builder.setItems(catNamesArray, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // реализовать сохранение в бд
                        if(which==0)
                        {
                            //getContext();
                            AppCompatActivity appCompatActivity = (AppCompatActivity) getContext();
                            BlankFragment bFrag = new BlankFragment(position);
                            appCompatActivity.getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.mainFilm, bFrag).addToBackStack(null).commit();
                            dialog.dismiss();
                        }


                        if(which==1)//case mb
                        {
                            //Intent mIn = Intent.getIntentOld();
                            mBitmap mbit = new mBitmap();
                            SQLiteDatabase database = dbFilms.getWritableDatabase();
                            //dbFilms.onCreate(database);
                            ContentValues contentValues = new ContentValues();
                            int count = 0;
                            for(Film film : gData)
                            {
                                if(count==position)
                                {
                                    if(isFilm(film.name)) //по идеи надо еще проверять на кейюзера
                                    {
                                        count++;
                                        contentValues.put(dbFilms.KEY_USERS, "1337");
                                        contentValues.put(dbFilms.KEY_POSITION, position);
                                        contentValues.put(dbFilms.FILM_NAME, film.name);
                                        contentValues.put(dbFilms.FILM_STILE, film.stile);
                                        contentValues.put(dbFilms.FILM_YEAR, film.year);
                                        if (position < 3)
                                        {
                                            contentValues.put(dbFilms.FILM_IMAGE, film.photoId);
                                        }
                                        else
                                        {
                                            contentValues.put(dbFilms.FILM_BIT64, mbit.convertToBase64(film.nPic));
                                        }
                                        database.insert(dbFilms.TABLE_CONTACTS, null, contentValues);
                                    }
                                    else
                                    {
                                        count++;
                                        Toast.makeText(getContext(),
                                                "Фильм уже в избранном", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else { count++; }
                            }
                            chekdb();
                            dialog.dismiss();
                        }
                    }
                });

        return builder.create();
    }

    public boolean isFilm(String nameFilm)
    {
        SQLiteDatabase database = dbFilms.getReadableDatabase();
        Cursor cursor = database.query(dbFilms.TABLE_CONTACTS,
                null,null,null,null,null,null);

        if (cursor.moveToFirst())
        {
            //int idIndex = cursor.getColumnIndex(dbFilms.KEY_ID);
            //int myID = cursor.getColumnIndex(dbFilms.KEY_USERS);
            int nameIndex = cursor.getColumnIndex(dbFilms.FILM_NAME);
            //int passIndex = cursor.getColumnIndex(dbFilms.KEY_PASS);
            do {

                String name = cursor.getString(nameIndex);
                if(nameFilm.equals(name))
                {
                    Log.d("Film","have");
                    cursor.close();
                    return false;
                }
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");

        cursor.close();
        return true;
    }

    public void chekdb()
    {
        SQLiteDatabase database = dbFilms.getReadableDatabase();
        //database.execSQL("drop table if exists " + dbFilms.TABLE_CONTACTS);
        Cursor cursor = database.query(dbFilms.TABLE_CONTACTS,
                null,null,null,null,null,null);

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(dbFilms.KEY_ID);
            int myID = cursor.getColumnIndex(dbFilms.KEY_USERS);
            int nameIndex = cursor.getColumnIndex(dbFilms.FILM_NAME);
            int stileIndex = cursor.getColumnIndex(dbFilms.FILM_STILE);
            int yearIndex = cursor.getColumnIndex(dbFilms.FILM_YEAR);
            int imageIndex = cursor.getColumnIndex(dbFilms.FILM_IMAGE);
            int bitIndex = cursor.getColumnIndex(dbFilms.FILM_BIT64);
            do {
                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                        ", userID = " + cursor.getString(myID) +
                        ", filmname = " + cursor.getString(nameIndex) +
                        ", filmstile = " + cursor.getString(stileIndex) +
                        ", filmyear = " + cursor.getString(yearIndex) +
                        ", filmimge = " + cursor.getString(imageIndex) +
                        ", filmbit = " + cursor.getString(bitIndex));
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        cursor.close();
    }


}
