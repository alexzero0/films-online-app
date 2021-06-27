package com.example.myapptwo;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapptwo.ui.home.fragment.BlankFragment;

import java.util.List;

public class MyDialogFragmentG extends AppCompatDialogFragment {

    private int position;
    private int gPos = -1;
    private int gWhc = -1;
    private List<Film> gData;
    DBfilms dbFilms;
    //AdapterRecycle adapterRecycle;
    RecyclerView recyclerView;



    public MyDialogFragmentG(int psn, List<Film> gData)
    {
        position = psn;
        this.gData = gData;

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] catNamesArray = {"удалить", "отмена"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        dbFilms = new DBfilms(getContext());

        builder.setItems(catNamesArray, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                SQLiteDatabase database = dbFilms.getReadableDatabase();
                // реализовать удаление из бд и далее обновление списка
                if(which==0)
                {

                    //AppCompatActivity appCompatActivity = (AppCompatActivity) getContext();
                    //recyclerView = appCompatActivity.findViewById(R.id.myrecycle);
                    //adapterRecycle = (AdapterRecycle) recyclerView.getAdapter();
                    Cursor cursor = database.query(dbFilms.TABLE_CONTACTS,
                            null,null,null,null,null,null);

                    if (cursor.moveToFirst()) {
                        int idIndex = cursor.getColumnIndex(dbFilms.KEY_ID);
                        int myID = cursor.getColumnIndex(dbFilms.KEY_USERS);
                        int kPos = cursor.getColumnIndex(dbFilms.KEY_POSITION);
                        int nameIndex = cursor.getColumnIndex(dbFilms.FILM_NAME);
                        int stileIndex = cursor.getColumnIndex(dbFilms.FILM_STILE);
                        int yearIndex = cursor.getColumnIndex(dbFilms.FILM_YEAR);
                        int imageIndex = cursor.getColumnIndex(dbFilms.FILM_IMAGE);
                        int bitIndex = cursor.getColumnIndex(dbFilms.FILM_BIT64);
                        do {
                            if(cursor.getString(nameIndex).equals(gData.get(position).name))
                            {
                                //Log.d("if","inside");
                                int id = cursor.getInt(idIndex);
                                int delCount = database.delete(dbFilms.TABLE_CONTACTS, dbFilms.KEY_ID+"="+id,null);
                                Log.d("mLog", "deleted rows count = " + delCount);
                                //adapterRecycle.notifyDataSetChanged();
                            }
                        } while (cursor.moveToNext());
                    } else
                        Log.d("mLog","0 rows");
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
    }


}

