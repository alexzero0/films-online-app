package com.example.myapptwo.ui.gallery;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapptwo.AdapterRecycle;
import com.example.myapptwo.DBfilms;
import com.example.myapptwo.Film;
import com.example.myapptwo.R;
import com.example.myapptwo.databinding.FragmentGalleryBinding;
import com.example.myapptwo.mBitmap;
import com.example.myapptwo.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    private List<Film> films;
    private SwipeRefreshLayout mySwipeRefreshLayoutG;
    List<Film> nData;
    DBfilms dbFilms;

    //private boolean myFlag = true;

    RecyclerView recyclerView;
    AdapterRecycle adapterRecycle;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        dbFilms = new DBfilms(getContext());

        nData = initData();

        recyclerView = binding.myrecyclegal;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapterRecycle = new AdapterRecycle(getContext(),nData);


        mySwipeRefreshLayoutG = binding.swipeToRefreshgalG;
        mySwipeRefreshLayoutG.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                nData.clear();
                films = new ArrayList<>();
                mBitmap mbit = new mBitmap();
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

                        if(cursor.getString(bitIndex) == null)
                        {
                            films.add(new Film(cursor.getString(nameIndex),
                                    cursor.getString(stileIndex),
                                    cursor.getString(yearIndex),
                                    cursor.getInt(imageIndex), null));
                        }
                        else
                        {
                            films.add(new Film(cursor.getString(nameIndex),
                                    cursor.getString(stileIndex),
                                    cursor.getString(yearIndex),
                                    0, mbit.convertToBitmap(cursor.getString(bitIndex))));
                        }
                        //films.add(new Film());
                    } while (cursor.moveToNext());
                } else
                    Log.d("mLog","0 rows");

                cursor.close();
                nData.addAll(films);
                adapterRecycle.notifyDataSetChanged();
                mySwipeRefreshLayoutG.setRefreshing(false);
            }
            });



        recyclerView.setAdapter(adapterRecycle);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private List<Film> initData()
    {
        films = new ArrayList<>();
        mBitmap mbit = new mBitmap();
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


        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(dbFilms.KEY_ID);
            int myID = cursor.getColumnIndex(dbFilms.KEY_USERS);
            int nameIndex = cursor.getColumnIndex(dbFilms.FILM_NAME);
            int stileIndex = cursor.getColumnIndex(dbFilms.FILM_STILE);
            int yearIndex = cursor.getColumnIndex(dbFilms.FILM_YEAR);
            int imageIndex = cursor.getColumnIndex(dbFilms.FILM_IMAGE);
            int bitIndex = cursor.getColumnIndex(dbFilms.FILM_BIT64);
            do {

                if(cursor.getString(bitIndex) == null)
                {
                    films.add(new Film(cursor.getString(nameIndex),
                            cursor.getString(stileIndex),
                            cursor.getString(yearIndex),
                            cursor.getInt(imageIndex), null));
                }
                else
                {
                    films.add(new Film(cursor.getString(nameIndex),
                            cursor.getString(stileIndex),
                            cursor.getString(yearIndex),
                            0, mbit.convertToBitmap(cursor.getString(bitIndex))));
                }
                //films.add(new Film());
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");
        return films;
    }
}