package com.example.myapptwo;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapptwo.ui.home.fragment.BlankFragment;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import com.example.myapptwo.ui.aboutFilm;


public class AdapterRecycle extends RecyclerView.Adapter<AdapterRecycle.ViewHolder>
{
    private LayoutInflater layoutInflater;
    private List<Film> data;
    //List<aboutFilm> odata;
    DBfilms dbFilms;
    private boolean isSpeakButtonLongPressed = false;

    public AdapterRecycle(Context context, List<Film> ndata)
    {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = ndata;
        dbFilms = new DBfilms(context);
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.custom_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycle.ViewHolder holder, int position)
    {

        String tName = data.get(position).name;
        holder.textName.setText(tName);

        String tStile = data.get(position).stile;
        holder.textStile.setText(tStile);

        String tYear = data.get(position).year;
        holder.textYear.setText(tYear);

        // for image // need create struct // I go sleep
        Bitmap bitImage = data.get(position).nPic;
        if (bitImage == null) {
            int tImage = data.get(position).photoId;
            holder.imPoster.setImageResource(tImage);
        }
        else
        {
            //Log.i("Internet Pict","yes");
            holder.imPoster.setImageBitmap(bitImage);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();

                Fragment nHome = appCompatActivity.getSupportFragmentManager()
                        .getFragments().get(0).getChildFragmentManager()
                        .getFragments().get(0);
                String i = nHome.toString().split(" ")[0].split("\\{")[0];


                /*Fragment hFrag = null; //=  appCompatActivity.getFragmentManager().findFragmentById(R.id.nav_home);
                FragmentManager fragmentManager =  appCompatActivity.getSupportFragmentManager();
                List<Fragment> fragments = fragmentManager.getFragments();
                if(fragments != null){
                    for(Fragment fragment : fragments){
                        if(fragment != null && fragment.isVisible())
                            hFrag = fragment;
                    }
                }
                Fragment chFrag = null;
                List<Fragment> cfragments = hFrag.getParentFragmentManager().getFragments();
                if(cfragments != null){
                    for(Fragment fragment : cfragments){
                        if(fragment != null && fragment.isVisible()) {
                            chFrag = fragment;

                            Fragment ccfragments = chFrag.getParentFragment();

                        }
                    }
                }*/

                //chFrag.getT
                //.getChildFragmentManager()
                //androidx.fragment.app.Fragment nhFrag = appCompatActivity.getSupportFragmentManager()
                //Fragment lol = hFrag.getChildFragmentManager().findFragmentByTag("hometag");
                if (i.equals("HomeFragment"))
                {           //HomeFragment{527157a} (b26ad6f2-0475-4290-92e0-395e7c263dd2 id=0x7f08011b)
                    BlankFragment bFrag = new BlankFragment(position);
                    appCompatActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.mainFilm, bFrag).addToBackStack(null).commit();
                }
                else if(i.equals("GalleryFragment"))
                {
                    SQLiteDatabase database = dbFilms.getReadableDatabase();
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
                            if(cursor.getString(nameIndex).equals(data.get(position).name))
                            {
                                Log.i("if","inside");
                                int new_pos = cursor.getInt(kPos);
                                BlankFragment bFrag = new BlankFragment(new_pos);
                                appCompatActivity.getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.mainFilmG, bFrag).addToBackStack(null).commit();

                            }
                        } while (cursor.moveToNext());
                    } else
                        Log.d("mLog","0 rows");

                }
                //Log.d("log1", hFrag.getTag());

            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
                Fragment nHome = appCompatActivity.getSupportFragmentManager()
                        .getFragments().get(0).getChildFragmentManager()
                        .getFragments().get(0);
                String i = nHome.toString().split(" ")[0].split("\\{")[0];


                if (i.equals("HomeFragment")) {
                    MyDialogFragment myDialogFragment = new MyDialogFragment(position, getData());
                    myDialogFragment.show(appCompatActivity.getSupportFragmentManager(), "customHom");

                }
                else if(i.equals("GalleryFragment"))
                {
                    MyDialogFragmentG myDialogFragmentG = new MyDialogFragmentG(position,getData());
                    myDialogFragmentG.show(appCompatActivity.getSupportFragmentManager(),"customGal");
                    isSpeakButtonLongPressed = true;
                }
                return true;
            }
        });



        /*holder.itemView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //v.onTouchEvent(event);
                Log.d("onTouch","ins");
                // We're only interested in when the button is released.
                if (event.getAction() == MotionEvent.AXIS_X) {

                    Log.d("onTouch", "if");
                    // We're only interested in anything if our speak button is currently pressed.
                    if (isSpeakButtonLongPressed) {
                        Log.d("onTouch", "if-if");
                        // Do something when the button is released.
                        isSpeakButtonLongPressed = false;
                        notifyDataSetChanged();

                    }
                }
                return false;
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public List<Film> getData() {
        return data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textName,textStile,textYear;
        ImageView imPoster;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.nameFilm);
            textStile = itemView.findViewById(R.id.nameStile);
            textYear = itemView.findViewById(R.id.nameYear);
            imPoster = itemView.findViewById(R.id.imagePoster);
        }
    }


}
