package com.example.myapptwo;

import android.graphics.Bitmap;

public class Film {
    String name;
    String stile;
    String year;
    int photoId;
    Bitmap nPic = null;
    public Film(String name, String year, String stile, int photoId, Bitmap nPic) {
        this.name = name;
        this.stile = stile;
        this.year = year;
        if(photoId != 0)
            this.photoId = photoId;
        else if(nPic != null)
            this.nPic = nPic;
        else
            this.nPic = null;
    }
}
