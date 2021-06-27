package com.example.myapptwo.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapptwo.AdapterRecycle;
import com.example.myapptwo.Film;
import com.example.myapptwo.R;
import com.example.myapptwo.databinding.FragmentHomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private List<Film> films;
    private SwipeRefreshLayout mySwipeRefreshLayout;
    private FloatingActionButton fab;
    List<Film> nData;

    private boolean myFlag = true;
    public int isHome = 1;

    RecyclerView recyclerView;
    AdapterRecycle adapterRecycle;

    public int getIsHome() {return isHome;}


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        nData = initData();

        ConstraintLayout rec = binding.mainFilm;
        rec.setTag("hometag");

        recyclerView = binding.myrecycle;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapterRecycle = new AdapterRecycle(getContext(),nData);

        mySwipeRefreshLayout = binding.swipeToRefresh;
        fab = binding.fab1;
        mySwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
          @Override
          public void onRefresh() {
              Log.i("refresh: ","yes");
              if(myFlag) {
                  Log.i("NewThread: ","yes");
                  NewThread nTask = new NewThread();
                  nTask.execute();
                  myFlag = false;
              }
              mySwipeRefreshLayout.setRefreshing(false);
          }
      });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.scrollToPosition(0);
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

        films.add(new Film("Обитель зла: Вырождение","2008","мультфильм",R.mipmap.ic_film1_foreground,null));
        films.add(new Film("Обитель зла: Проклятие","2012","мультфильм",R.mipmap.ic_film2_foreground,null));
        films.add(new Film("Обитель зла: Вендетта","2017","мультфильм",R.mipmap.ic_film3_foreground,null));
        return films;
    }

    class NewThread extends AsyncTask<String, Void, List<Film>> {

        @Override
        protected List<Film> doInBackground(String... args) {
            Document doc;
            List<Film> newFilm = new ArrayList<>();
            List<String> nameFilm  = new ArrayList<>();
            List<String> sInfoFilm = new ArrayList<>();
            List<String> sStileFilm = new ArrayList<>();
            List<Bitmap> bitmap = new ArrayList<>();

            try
            {

                doc = Jsoup.connect("https://www.kinopoisk.ru/lists/top250/").get();
                //Elements infoFilm = doc.select("div.styles_lg_15__3ZroS");
                Elements nameFilms = doc.select("p.selection-film-item-meta__name");
                Elements sInfoFilms = doc.select("p.selection-film-item-meta__original-name");
                Elements sStileFilms = doc.select("span.selection-film-item-meta__meta-additional-item");
                Elements nPichers = doc.select("img");

                for(Element el : nameFilms)
                {
                    nameFilm.add(el.text());
                    //Log.i("nameFilm",el.text());
                }
                for(Element el : sInfoFilms)
                {
                    sInfoFilm.add(el.text());
                    //Log.i("sInfoFilm",el.text());
                }
                for(Element el : sStileFilms)
                {
                    if((sStileFilms.indexOf(el) & 1) == 0)
                        continue;
                    sStileFilm.add(el.text());
                    //Log.i("sStileFilm",el.text());
                }
                for(Element el : nPichers)
                {
                    if((nPichers.indexOf(el) > 24) && (nPichers.indexOf(el) < 75))
                    {
                        String imSrc = el.absUrl("src");
                        //Log.i("src",imSrc);
                        InputStream input = new java.net.URL(imSrc).openStream();
                        bitmap.add(BitmapFactory.decodeStream(input));
                    }
                }
                for(int i = 0; i<3; i++)
                {
                    newFilm.add(new Film(nameFilm.get(i),sInfoFilm.get(i),sStileFilm.get(i),0,bitmap.get(i)));
                }
            } catch (IOException e) {e.printStackTrace();}
            return newFilm;
        }

        @Override
        protected void onPostExecute(List<Film> result)
        {
            nData.addAll(result);
            adapterRecycle.notifyDataSetChanged();
        }
    }
}