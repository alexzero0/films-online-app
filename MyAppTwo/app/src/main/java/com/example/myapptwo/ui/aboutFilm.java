package com.example.myapptwo.ui;

import android.graphics.Bitmap;


public class aboutFilm {
    String infoFlm,oFlm;
    Bitmap imageFlm = null;
    public aboutFilm(String infoFlm, String oFlm, Bitmap imageFlm)
    {
        this.infoFlm = infoFlm;
        this.oFlm = oFlm;
        if (imageFlm == null)
            this.imageFlm = null;
        else
            this.imageFlm = imageFlm;
    }
}
