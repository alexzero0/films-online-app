package com.example.myapptwo.ui.home.fragment;
import com.example.myapptwo.ui.aboutFilm;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapptwo.Film;
import com.example.myapptwo.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    private TextView infoFlm,oFlm;
    private ImageView imageFlm;
    private int position;
    //List<aboutFilm> odata;

    public BlankFragment(int psn)
    {
        position = psn;
        //odata = data;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        imageFlm = view.findViewById(R.id.imageFilm);
        infoFlm = view.findViewById(R.id.infoFilm);
        oFlm = view.findViewById(R.id.oFilm);
        //позиция что отображать я знаю через конструктор,
        // осталось по ниму определить, что скачать, скачать и поставить
        NewThread newThread = new NewThread();
        newThread.execute(position);

        return view;
    }



    class NewThread extends AsyncTask<Integer, Void, List<aboutFilm>> {

        private String iFilm,oFilm;
        private Bitmap pFilm;
        @Override
        protected List<aboutFilm> doInBackground(Integer... args) {

            int pos = args[0];
            ForFilm fF = new ForFilm();
            Document doc;
            //List<aboutFilm> newFilm = new ArrayList<>();
            //List<String> infoFilm = new ArrayList<>();
            //List<String> oFilm = new ArrayList<>();
            //List<Bitmap> bitmap = new ArrayList<>();

            try {
                //newFilm.clear();
                iFilm = null;
                oFilm = null;
                pFilm = null;
                if(pos==0)
                {
                    doc = Jsoup.connect(fF.MyFilm1).get();

                    Elements infoFilms = doc.select(fF.infoMyFilm);
                    Elements oFilms = doc.select(fF.oMyFilm);
                    InputStream input = new java.net.URL(fF.FilmImage1).openStream();
                    Bitmap mImg = BitmapFactory.decodeStream(input);

                    iFilm = infoFilms.text();
                    oFilm = oFilms.text();
                    pFilm = mImg;

                    Log.i("iFilm",iFilm);
                    Log.i("oFilm",oFilm);
                    //newFilm.add(new aboutFilm(infoFilms.text(),oFilms.text(),mImg));
                }
                if(pos==1)
                {
                    doc = Jsoup.connect(fF.MyFilm2).get();

                    Elements infoFilms = doc.select(fF.infoMyFilm);
                    Elements oFilms = doc.select(fF.oMyFilm);
                    InputStream input = new java.net.URL(fF.FilmImage2).openStream();
                    Bitmap mImg = BitmapFactory.decodeStream(input);

                    iFilm = infoFilms.text();
                    oFilm = oFilms.text();
                    pFilm = mImg;

                    Log.i("iFilm",iFilm);
                    Log.i("oFilm",oFilm);
                    //newFilm.add(new aboutFilm(infoFilms.text(),oFilms.text(),mImg));
                }
                if(pos==2)
                {
                    doc = Jsoup.connect(fF.MyFilm3).get();

                    Elements infoFilms = doc.select(fF.infoMyFilm);
                    Elements oFilms = doc.select(fF.oMyFilm);
                    InputStream input = new java.net.URL(fF.FilmImage3).openStream();
                    Bitmap mImg = BitmapFactory.decodeStream(input);

                    iFilm = infoFilms.text();
                    oFilm = oFilms.text();
                    pFilm = mImg;

                    Log.i("iFilm",iFilm);
                    Log.i("oFilm",oFilm);
                    //newFilm.add(new aboutFilm(infoFilms.text(),oFilms.text(),mImg));
                }
                if(pos==3)
                {
                    doc = Jsoup.connect(fF.MyFilm4).get();

                    Elements infoFilms = doc.select(fF.infoMyFilm);
                    Elements oFilms = doc.select(fF.oMyFilm);
                    InputStream input = new java.net.URL(fF.FilmImage4).openStream();
                    Bitmap mImg = BitmapFactory.decodeStream(input);

                    iFilm = infoFilms.text();
                    oFilm = oFilms.text();
                    pFilm = mImg;

                    Log.i("iFilm",iFilm);
                    Log.i("oFilm",oFilm);
                    //newFilm.add(new aboutFilm(infoFilms.text(),oFilms.text(),mImg));
                }
                if(pos==4)
                {
                    doc = Jsoup.connect(fF.MyFilm5).get();

                    Elements infoFilms = doc.select(fF.infoMyFilm);
                    Elements oFilms = doc.select(fF.oMyFilm);
                    InputStream input = new java.net.URL(fF.FilmImage5).openStream();
                    Bitmap mImg = BitmapFactory.decodeStream(input);

                    iFilm = infoFilms.text();
                    oFilm = oFilms.text();
                    pFilm = mImg;

                    Log.i("iFilm",iFilm);
                    Log.i("oFilm",oFilm);
                    //newFilm.add(new aboutFilm(infoFilms.text(),oFilms.text(),mImg));
                }
                if(pos==5)
                {
                    doc = Jsoup.connect(fF.MyFilm6).get();

                    Elements infoFilms = doc.select(fF.infoMyFilm);
                    Elements oFilms = doc.select(fF.oMyFilm);
                    InputStream input = new java.net.URL(fF.FilmImage6).openStream();
                    Bitmap mImg = BitmapFactory.decodeStream(input);

                    iFilm = infoFilms.text();
                    oFilm = oFilms.text();
                    pFilm = mImg;

                    Log.i("iFilm",iFilm);
                    Log.i("oFilm",oFilm);
                    //newFilm.add(new aboutFilm(infoFilms.text(),oFilms.text(),mImg));
                }



            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(List<aboutFilm> result)
        {
            imageFlm.setImageBitmap(pFilm);
            infoFlm.setText(iFilm);
            oFlm.setText(oFilm);
        }
    }

    class ForFilm
    {
        public String MyFilm1 = "https://www.kinopoisk.ru/film/405450/";
        public String infoMyFilm = "div.styles_lg_15__3ZroS";
        public String oMyFilm = "p.styles_paragraph__2Otvx";
        public String FilmImage1 = "https://kinopoisk-ru.clstorage.net/b14i6T268/1a1c7e9nI/5uzUnkeAlL006PL_mrp1hpU4Z26c1WTaLMuf09H7UGYEMPNzzU_sjpa3JoDtj0w5j82y3PNzfZNQtPHOwHexqdfliMcK_NDUQbWKhrPfBMflXUoemdhd-3Xb656klizaxJA71gXXEC4WBqOZ1IMtRP6Qs9zXTzTyfbXgB3wW7CTGDNT-62ARIZgwqw9i7oWqlU0LBqg0hJLkVmer-Yt8OlD8j8rNx1xObkJbHZzWBdR26G-0V8sQOwnF7MflytS4dmSAXgPYSQk0GF-jwgJ9VtltRx7AsJSa3IY7a_0DdLKgpG_OmT_4StLGsxWUalXAuqS_0D97aI-hWXhbZU4kNCocOELXmIntrCCfi0YCqYbZYedaPKB4prxeOzeR09AuZNBnji2rDGoedofZAPI5tA7IN1AjX1TbiUkw2zVWKKy-DATmY9TtPazgf4e-8tEaqeV3moDg9OagkmM_3WNMPgxEB75J40CuVq7fVYyWXXxW6IcgN1vs80Gx7P-VcqTc5mwAJtMcec005APnYvqJmjV1h_Y4FPACoHKnu_nzTP5kJBfCPbtEQuLq2xmEWllg9nyLjI-7qJ_BZbgnGZLoMOr82AZb3IEZtLjz70qmaVKtifOSvBzQmiiyS-_Na-gCjCgLSi1zlCaCDtshpAqpAAagz0CD-6hzCelca7U2sFS-oAieK1RF7UTki-9udqXSMbEPjmy47Bogim_LOevEqiQks5pt93QuLjKLcRRSyVwa6Fvc72_0FyVRaLNJUozo_tB0Wt_sBcHQ4LdzGhJtGo1tg-qsYPyOlKJLn_nL8OLk0NcOtePkvl4yp_28yjE08iyfUPt3QINt6WAbLY7MpMJ0fH5L1M3BEDSPX0b2fQKladNekFgA6nz-r8td32hihDxXFiXL6EKCyltpsL7BvBpgU0APQzC7pVWEy0US0MxWMGT6XwS5zaggD6P65mXOURUPXli84EJ0trdTlYvEZgQ8Czqh8xDKPiqPwchKPTB-zJ8gI_Pgx4lpmM8ZxtBEriDAGtMIUQ2Q7AfTIl59HjUZx3YUGBTKgFpLX2XrrPbcnCNWcSPAxjqqfy0wnnGk3vjflL-rTDuZvQAflUqk7O7QhJ5rWO2tTGA7r1badR4FRZfq3MgAkqyui89ZCzQWoNCHvm1fjBoeBrvRbMI1JNLAX6w_o8SPhcX8f5F--FSuZPBqo4zhlbCQe0OWctEKXfFL4sgYAOK8ouvzbQd0gix8t-a5D5iqSvLDBUT2hUjySNtQJ4sgN8npJMvRnkiofhSAdvNokU1QuCtveoqJAr3Fy16EmAhuLKYvq9GnqELwMHs27S8YEqo-0yXsxlEM-uwfzFOj2EMdwaTP0YpQcNbwsIpTnFGdKDSbj-4aKbbdzRNarMhMwuwel-Mdn_B6ENS3ms3fhEJSNleJRFrVtLL0O6zHfzT3kXUY67ECwMBCgGhCh2yZZTj8h1eaLhnGKY3_PsQYZAb8omMfRVdgFpTY2_r9A7iCIn4z_WAGOcj6aAcYZ_NAm2nFZJ8ZpoDo1lCcplOsmTUcmAvDPjrhWo29G1I0gAj-FNo3wy0nvGqQNKfuEdeExm7iy_WY9il4hhxbDCMDRDchTZRr2c7EsEa46Cpf0N1JQEj3lz6aEVpdnUdCtJgUQtwms_vhx3C6jJzrbnGvyKoqZgOtJA51sA5wi3QPd7zL9Smczx0yNLw26LACowRV2ZBEi8u-bl1aDYkXwsgcYJZgTiOrrev4vrww2xb1y5RaNmbXYSzOQUw-GL_Mxwtom9VJKGctonAgrrx46uvoyZFA6JtTUnL1Wh3pj-pMkDju-Cbzt_3foHaMACvqMbOUTi52C8nsBimAwogTWGfP_DdB6SxTyV7MoDpohCrTaGFBOKh3FxoK8a7B-RsKFADMQgiq70_tl_TC6Ez7ZhlPCKK-PpeRPPqxvPqUv9A_I6ST9eHQ2wWq6BDuvHjGh2TR1aycf5-WhkleMZELSqDQ1IbcMi9HYRvkfqSsB2pZyxQWyjYTpRiGDfgKaNcQb7PoC1HhUH8xukCounS0fhMUnTnINH8HHqp1Iq2B1zbErEjOHNZzn-EfVOYkkOtiOft0YsJui3mM-plYdpwzEC-rEIt5UejrhZLUZOagsNYL9AXhLHDve3r2Qdbp0fN6tFAwnmRWl2t5mzgSDNwTWp3X6NqOJsttbNo5QPLs14in8zwDCbn00-GCDCRmLIj6J-yRzdAc8wPS5p0ujTGDAoQIgNqsRpu_yW9k6uxMF-I9R4i-6j5TobC-hSAaIMNMc1MYC_UxHK_RXqSgVvQwKvscQUWYMBcjsm7VytE9k9JY7AAuhNoP53mLCD6QxFueRXs8UqomS5GMDpkg_hC3uNdzND_hXXBLSfZM1PbgbMrfbBmVJNz7a0KqgSpNFQ9OJAgIUuzSe2tVf_yqCFQb4p1nEJKyCq8dpELJYPYch0wzQ1Bb6WmcrwXaIDR6ZFRGR4g9DRSwJxOuHi3eRY2L5tBYbJJgXmdfudd0ctCMOxbl2-xuWg6nhchaRQjeTNvQozckO9lhAEdZLiw85jiMatNwRQ1AROcnXg5B2oWJtx68AATqZK6nv5GnBK7gXBdqNV9ohpamR-kA1j005rzDxFvfvENhreg_YSYgsKakwHZXKAWVRDzbB0pqxbbRif_2RMwYEmiGz2_9R_Q-BLx_yinviDqisotJSAYhzGK8a6izgyjbdTX8q9XebOhK1DjaC0yZYSxUk-8m-mH-JdHjytBMeA4sRk_XfftgknTEfwa1_0iSUoY3ZbDWudR2vJsgI1vMH3HJBBsFDoBsVnRUDgesHZWwQJdL4gZlQiEZ9_KwNER-FK53G3knOE7Q8JsSRYv8TtK2k5G8gv3wvpgnoA9bcPPd5Xy7BVLclCp0_BrndEktOJhzZ_LaAV450QcClLgY7piKl-fph1Ri9DxXUqnLQNpuBsMlXBp9CI44CyBb2_yfhTUI";
        public String MyFilm2 = "https://www.kinopoisk.ru/film/576450/";
        public String MyFilm3 = "https://www.kinopoisk.ru/film/576450/";
        public String MyFilm4 = "https://www.kinopoisk.ru/film/326/";
        public String MyFilm5 = "https://www.kinopoisk.ru/film/435/";
        public String MyFilm6 = "https://www.kinopoisk.ru/film/3498/";

        public String FilmImage2 = "https://kinopoisk-ru.clstorage.net/l2894cl03/ad0a84ZYbuc/UdB0uxIv5AFZTdFi5hV_kEBUhbjx2jPaU-6crZWwpicwr-cjHEB68oW7jrfJI9g43jyRlI66-73VWKGeXnLojNABdGzWfLLVTssCtLFU6xbGQ9F8dkgmS1SqS_tCe2otPCW7qpOKcvmd6h4kTPUO7U4tkwDe7Cl4xEQ7T0myuNLV1j07FbQtQJmUVmdj2LPdHxuAcONYfxWAbJZsUPrn7n7uNyNbhXh-3GpYb9f-BqvH7diP0mqx9wXJORQCP7tYURly9RMybk2UHFQmrNgwld2TCTjnlfsdwSTTqhy15q4863llWYHxNt2q0qOcPkXqBqeaCRyiMDnLwv4cg3E40BURPrVS-K4JHx4W526eMpAZV4Exrpp524GhkqUUMeHheub94J2GsPEb5d-nFXGMLA7hUoCQq_cxQEJ1kgT_flPdnn63Hf1sSpASXmdgV_pX0ZqJsGiZ-Z7DrltiUjgrqD8ptSyWCPpwFiKaK9K_QeDEpdJD3KI7uA0H-d8P_3NTFR--O9x1JkkQkFpqJtH4nRsaiLUokj_eCuodbty3Y6z9pfdr2srxf1esFWvWM0RmjS3aiNMks_GLCvEWSLs3H5fYcPIcfyICExPeaiHQNJDaVYd8aZ37FMKlkiaU-G-s-G85bFLFfrNSLR9kWryCLMdpXIPW5_-1Bcs8XAf2N9zV2bS6nr5rzFzWGW7m1nPVmFGMfCDf-tQDpVJmWP9trn4tfuHcgLO4la2eaF12DutJYVoGH-rz_0eFv9qDsbaRGRXy-tWw48LYnx0prR3y15CXTX-oEH9eymLWpdX-oOe97bYnUgS3f1Os3moX9EblR-KSwBMldH1CT3FfBjBxE1rZOvMbOmrGE9Vdb6Dd9J_fHg31aRL5HUVmXaUceKyrPmiy6RSJdrCerJXtXXZNp8ZiFsiS6Pj1SUZ43Ac3fp_aHb97G7HtBBfYUqHlWHDfXlzNNSDRuBLMaJSt2Pcjb7Wh9Csfi3d5UOtep9l6hGTIoRzLkWC4-M0P_l0PNDXV2Fm_flx1JQSREh3uLJ-9VJnWBbluWT8aBubYoBzy5669qLTiXcU7uxLm02TW-0jsiO_bxt4kPzbIgXGWxPd6GVjUuDrSsmfDkNrU4O6e81-WWkH9Lhn61QQmHO8UeCEk9qH5JJRFt3sdZtVsHDbOIkDjmIZY6vd0gAp81w6zMxUcnDl-m76rDVcTkWtj2byf3xaPsGxVsV-Fb9WtEPzgY_Wt_SxfSfby1KJW5VW-AG1NJBLA0S90tcNNv1pCcfZQl5-wt9r464RemFspLVl-XBaaDLUqXjrZxKLbaxPxLC73ZDAoUYQ29Zzpkilf8cElhCSdAx_reLcMB_7Uhzs40Z1V_3IQsWEEWV_f5Cjc8N4eH4i-rlq2ng3nGyJfdynot2e24FUGsbAW7h4o3TUA6sBjmAleLH59hwgxFETy9ZMQlr7yUzomxRySmihnGXwXEJzKeaOee15MpB0oVLWsJb6gsaWTwjB5HKaaIhyxyecOKRwH0e-3tQBPPNpJOzdV2tz5ehxw7M2XFJYiZ9T_kxfTzLnhF3SUzuaa5dewZKdxq38s206w-1UvFmicOwkoiCgah5FneH_DgngUj7IwGxlXPnGeMOeL2drf4-EUuleRkkx3alC_W0qqEqOUeSynPKE_KB4FOT3U6xqgm_wAqgYgEgYf777wgg4_mkJ6s1ETFfp92n-tghjdEq4gEjYVXd3BuWGSO9UIKdxvUjCuaTQktSgRQ_kwnqZdZZqziKSMoRvCEuY5usoBMB7KdrfdmpN_dRR9ogCYW1zg7Fr0F9BfQfki1bhcAiBdppS1YKtxYX2oVsJ1txQtVmqZckGmAepUwl5n_3aDRvGVz7C2FVObd3PdcKxDndIbI-vWNBQTGYn5aJi8nQAhHqJd8qxlvmy3aFYGvrFd6pbtF_RBp0YsEYobLjd3Ck__VIMwvpAYWLRy1LGqDBzUHGJskLRS21qENynacV5KINjm17TmLLem-uIbirG91aWbYl80RSPB49WG2qKzdwDJOB_H-zJcG1t4Pt38o4Af39Pmb5k_lRAeDzzoWb4dQGZd5Zay5-v07DwonErx_16jF2VUtwZnDOuUjtDn8bfIgXKVQjzyE1uc_DTQ9KrKHhbdLq3X85XSlgr_r19yH4stnyiX92Yn-K68qt0Ee_AT6pmgUrKKIMNkUouYIzK9gs31E4G3fpVUGfh-XHmsAhmWk-ir0fdWmdXJdCgW-hKAZloj3v0k6fBsvy3Whrt5lCoS5NWzzOBJpdRG3iBydAcId9FCcPYfUFC9OxXwJYSeW1Gob5CzVVLdDr7mFvDRTa5S7Vz-b2Q6LXmikQh4tZUk2yAdNEfkh6jRytyre7iKgbTdTno2UVjcdj2X-GtFFJwT4mXZt1Bam0g265-7FQkkFq-WP2_hOOgy7NdOvXYU5dIoXHeFZAvt2clWY3bxA012HYZy_p-S1bg6l78hSdTdXOAl1TxX0p_GeWPbMdZCotculL5or76m-umSzXr2kiSSpZq8iihA4lJI0GL3-I3DvVxKMXmQnBw-tp2-4UzUFxViZRH0mlFdDfkh3f7dza2YbJY0J6v05zjgWkG5Mdcnl-xaso1ghaIdjpwlvrSMgbZcSTQyk9AffD4VtysDH1we769Rdp7RlAQ04595XYbk0yiaOumncKawZxEDeLCfLNgk3LXM7cToGoffKvv_gw-x0k65cxVVVvByXf0hC5sY0ayh1T4d11QHdGLZvNoEKVerUHCm5rgsfqMXi3j11a7ebBk0jiOM75pG1-o6fUKKtpnL-TIRlF-8c1d2rEuV2NRspB91FNbcyPDikrIWya9YrZ99ZWaxbb7hmwHz_5Ml2Wvf8cTvBKMSCdeqeXjMQX0Swfw5ERDdNXoXfqpClNQSZyjWtR1fkkexrJkz34bn3-WfceGguOf3KRoLurZaolFrUjyPI8niEQtQqzd2BI";
        public String FilmImage3 = "https://kinopoisk-ru.clstorage.net/l2894cl03/ad0a84ZYbuc/UdB0uxIv5AFZTdFi5hV_kEBUhbjx2jPaU-6crZWwpicwr-cjHEB68oW7jbWLYhq43ijFFtq7u-hVmLUeHiQojNADIazWqjEUDsgCtjHAqIBGQoX8tggmS1SqS_tCe2otPCW7qpOKcvmd6h4kTPUO7U4tkwDe7Cl4xEQ7T0myuNLV1j07FbQtQJmUVmdj2LPdHxuAcONYfxWAbJZsUPrn7n7uNyNbhXh-3GpYb9f-BqvH7diP0mqx9wXJORQCP7tYURly9RMybk2UHFQmrNgwld2TCTjnlfsdwSTTqhy15q4863llWYHxNt2q0qOcPkXqBqeaCRyiMDnLwv4cg3E40BURPrVS-K4JHx4W526eMpAZV4Exrpp524GhkqUUMeHheub94J2GsPEb5d-nFXGMLA7hUoCQq_cxQEJ1kgT_flPdnn63Hf1sSpASXmdgV_pX0ZqJsGiZ-Z7DrltiUjgrqD8ptSyWCPpwFiKaK9K_QeDEpdJD3KI7uA0H-d8P_3NTFR--O9x1JkkQkFpqJtH4nRsaiLUokj_eCuodbty3Y6z9pfdr2srxf1esFWvWM0RmjS3aiNMks_GLCvEWSLs3H5fYcPIcfyICExPeaiHQNJDaVYd8aZ37FMKlkiaU-G-s-G85bFLFfrNSLR9kWryCLMdpXIPW5_-1Bcs8XAf2N9zV2bS6nr5rzFzWGW7m1nPVmFGMfCDf-tQDpVJmWP9trn4tfuHcgLO4la2eaF12DutJYVoGH-rz_0eFv9qDsbaRGRXy-tWw48LYnx0prR3y15CXTX-oEH9eymLWpdX-oOe97bYnUgS3f1Os3moX9EblR-KSwBMldH1CT3FfBjBxE1rZOvMbOmrGE9Vdb6Dd9J_fHg31aRL5HUVmXaUceKyrPmiy6RSJdrCerJXtXXZNp8ZiFsiS6Pj1SUZ43Ac3fp_aHb97G7HtBBfYUqHlWHDfXlzNNSDRuBLMaJSt2Pcjb7Wh9Csfi3d5UOtep9l6hGTIoRzLkWC4-M0P_l0PNDXV2Fm_flx1JQSREh3uLJ-9VJnWBbluWT8aBubYoBzy5669qLTiXcU7uxLm02TW-0jsiO_bxt4kPzbIgXGWxPd6GVjUuDrSsmfDkNrU4O6e81-WWkH9Lhn61QQmHO8UeCEk9qH5JJRFt3sdZtVsHDbOIkDjmIZY6vd0gAp81w6zMxUcnDl-m76rDVcTkWtj2byf3xaPsGxVsV-Fb9WtEPzgY_Wt_SxfSfby1KJW5VW-AG1NJBLA0S90tcNNv1pCcfZQl5-wt9r464RemFspLVl-XBaaDLUqXjrZxKLbaxPxLC73ZDAoUYQ29Zzpkilf8cElhCSdAx_reLcMB_7Uhzs40Z1V_3IQsWEEWV_f5Cjc8N4eH4i-rlq2ng3nGyJfdynot2e24FUGsbAW7h4o3TUA6sBjmAleLH59hwgxFETy9ZMQlr7yUzomxRySmihnGXwXEJzKeaOee15MpB0oVLWsJb6gsaWTwjB5HKaaIhyxyecOKRwH0e-3tQBPPNpJOzdV2tz5ehxw7M2XFJYiZ9T_kxfTzLnhF3SUzuaa5dewZKdxq38s206w-1UvFmicOwkoiCgah5FneH_DgngUj7IwGxlXPnGeMOeL2drf4-EUuleRkkx3alC_W0qqEqOUeSynPKE_KB4FOT3U6xqgm_wAqgYgEgYf777wgg4_mkJ6s1ETFfp92n-tghjdEq4gEjYVXd3BuWGSO9UIKdxvUjCuaTQktSgRQ_kwnqZdZZqziKSMoRvCEuY5usoBMB7KdrfdmpN_dRR9ogCYW1zg7Fr0F9BfQfki1bhcAiBdppS1YKtxYX2oVsJ1txQtVmqZckGmAepUwl5n_3aDRvGVz7C2FVObd3PdcKxDndIbI-vWNBQTGYn5aJi8nQAhHqJd8qxlvmy3aFYGvrFd6pbtF_RBp0YsEYobLjd3Ck__VIMwvpAYWLRy1LGqDBzUHGJskLRS21qENynacV5KINjm17TmLLem-uIbirG91aWbYl80RSPB49WG2qKzdwDJOB_H-zJcG1t4Pt38o4Af39Pmb5k_lRAeDzzoWb4dQGZd5Zay5-v07DwonErx_16jF2VUtwZnDOuUjtDn8bfIgXKVQjzyE1uc_DTQ9KrKHhbdLq3X85XSlgr_r19yH4stnyiX92Yn-K68qt0Ee_AT6pmgUrKKIMNkUouYIzK9gs31E4G3fpVUGfh-XHmsAhmWk-ir0fdWmdXJdCgW-hKAZloj3v0k6fBsvy3Whrt5lCoS5NWzzOBJpdRG3iBydAcId9FCcPYfUFC9OxXwJYSeW1Gob5CzVVLdDr7mFvDRTa5S7Vz-b2Q6LXmikQh4tZUk2yAdNEfkh6jRytyre7iKgbTdTno2UVjcdj2X-GtFFJwT4mXZt1Bam0g265-7FQkkFq-WP2_hOOgy7NdOvXYU5dIoXHeFZAvt2clWY3bxA012HYZy_p-S1bg6l78hSdTdXOAl1TxX0p_GeWPbMdZCotculL5or76m-umSzXr2kiSSpZq8iihA4lJI0GL3-I3DvVxKMXmQnBw-tp2-4UzUFxViZRH0mlFdDfkh3f7dza2YbJY0J6v05zjgWkG5Mdcnl-xaso1ghaIdjpwlvrSMgbZcSTQyk9AffD4VtysDH1we769Rdp7RlAQ04595XYbk0yiaOumncKawZxEDeLCfLNgk3LXM7cToGoffKvv_gw-x0k65cxVVVvByXf0hC5sY0ayh1T4d11QHdGLZvNoEKVerUHCm5rgsfqMXi3j11a7ebBk0jiOM75pG1-o6fUKKtpnL-TIRlF-8c1d2rEuV2NRspB91FNbcyPDikrIWya9YrZ99ZWaxbb7hmwHz_5Ml2Wvf8cTvBKMSCdeqeXjMQX0Swfw5ERDdNXoXfqpClNQSZyjWtR1fkkexrJkz34bn3-WfceGguOf3KRoLurZaolFrUjyPI8niEQtQqzd2BI";
        public String FilmImage4 = "https://kinopoisk-ru.clstorage.net/1u5E8d200/53688eTPZN_/tdkFkP8oslsgVJ2zxqkNGjQQdtrc4uHZ4eXPMpw5rd_IWj0lOpkug4kQclMWinTaYgWgdTtHHY0003p5VrpSLqAKU4J6r7FMZRTPp1A9CknyxnhQB2toEzlqgH5Fpn2P2R1q86rOatRfQKSUhlq7gabFvXHvlUoW6wIh_4Fm0fq5kEmes3m1W6cNHrgNaoHUq9q0FM1lYdV06kt1Q2wyyBSPqfBjB68V3o2kikRducp1Cjx4qtmM0-kFpzuJ5htwdl8InPt5eNihCVE5z2HH1GMW-xmGJWRe9y_LNY8vPIJdh-O4Icni2h1GLsbP1HEN8o4xuaNTjZGjwOS5jaJScfxYx5n1-nMeqc9ZOMlkzp_i2DmWTmGskbciCvqCL7ZK1YIs9-DOqJaejCOKQJY-BfxGOr8s0wET5cervUGu3Tf_WI_XMb5_H6WH3j9PbcccrlB6HUFmbBDy7sw0juVxDtQNIXjrByjcloTrDITSdY-3zbo-bpEMlCPHLPWFrFZ_ORRNHrJ-elqvD14wyKuBHuHQf90Mbatd8i2C_ELhtI_VBiZ_4Q9vHV2Fbs0GlnGD-g5_MibQjFzpTC-5imuXM7ZdyZW3N_BeasMZOgFqxZ1qUHERRCCp1fykRrrBbbzB3o-rsGmGYFUTCK8KARsywj-KsLwlmk3SYgMr8EnqGfk0kcOePvr83KZOmnaDYsjVZdF6nsMpJJa_oI_xjmw8z1bFqrqnR6eVFcCtRocefocySf-1qFqLUeVNLvvM5ZU6cZaM3zA2e5AvBpj4RO5JH24avxoGZaMZfyTLes2ofQeVDaG1I4Rj3xlIpYqGlrEC_Ui2caOfTNAqA-pzAyWaNjQdAZy_-fSRasyZNgxmgJluX_HcTWHhkXSrgDUHpLPHVoWkfSEE5JOcjSINiJF1jTdJfHiu0subogql-I3n03D-noWduTN6m-jK3fiELglQapi6EwlmYR3558RzBWOwgJcE5TOsxiWVHYQvRIGfuk26Tf91b1eGU-UL6zGOqBU7flAIVDt7fVlpRB6xgStJ364YstXH7mGeemQP_IymPA5WBqo76YGrV11JJ8kIE3AE98H08ibYgxxoByN1y6jbtLwZTx419jtarUtbOs3qSd1qFjNSASrlkb6njLvKJXGGmk0gt2_L7B9WAK6Hh9w1D3PHuP6nHsDTK8OtesIlXze0HYjXc3b61u7DmfGEaw-cbd3zVo2uIh76YIg5BON8w5QNpHFnT2uXUchjA4RWcg33yD4xIJCEFeQMLblE4l2ze92G1XfwcJBohpJ9B6aO2CaWOxWOL-wYeGOKs4xpfc9aTGi7681kHBbJ6gIBVj7LMoK2fW9ZxVXrSql3CK-RN_1ahJD-e3ve7geYPk5lTVYiXz8aTW6q0TBlTrzJZTnKXo1r_G0PbJ5UjmBFTt96RzwF__KmmkxR6I7kfMEun_s_Vc5Zs3E9n2wGUXdO4YGYbBj21A5qJZl5oIK0Aq7-SZEPZThiCaRalsgvCgbSf8q6iDX1ZFuCFOSO57eCaBDw-ddOHz_yudvgB5MxjWOBX2bSP9IO6KwWf63Lccdlsw-ayq4wI4kgWlaO7MpO3v2FPg158W2ZwtxjA2XxhOrfeTyQR5c297qX4UKbeg_mQldsH7dXDq7kWnGkQrHNpzDAUEKqs-yHbNIXwOjFix41BbeGPzTinsVRokZk80xnG3y038gZdjE_menN03EG6sYSIp68l0dvZZW-70N5Cqgyy1KHLXdrB2KVmIklBQvb_s8whnY5rJuIku0GZPoNpto8sFVAXn-wuBchBh2-gCpHHefWfZoJYqGa9i0GtwwheQqZDCvy6s7k1tQEJMeJ3D9P-IE9P2xSA1mvx-H4guhe-fTXTV52-jXfJsEetQZuhhqvUjwZxGYhmHGjS7vL7H0DWI1udSkIKtSWwSrMB1NxwzNHfzbikswRYAzrsIUsVv_03kefOfGwUClEXXJI7gUc4pu1n45h7h555Q81QucxylaPo3lgyOLTkQHkgoJW8Ih_CPp9LFBGke_OLXJBZNa8c96FVDf3spBsDlLywSrHHWEa-pXG5ixVP-APuspheI4WzeB7KAwlG1NPooLDWvfLdQK6sqZZQxVgRSt6yq3b_rbXR1B5dXyY5gyfccVrTV5kHfpeiWpqVTkrh3VMbbVPFQcssqhLp1vbjiQDxhGyz_-PMXRvUIPUoUAms8TuEXj830hW8X80W2jP1zkPbcwcZJM2F0RlqFg3Lk5zwmP0jphE4n9iBeJclAWoBojV9YV3iPV8LRtE1GvGKrdCZtc5PVeNETMxcp4iwhMxiyKIHW1SNJlLKGFQMWgMNUQrdI-ZSii7rEltEpbHLglHFD1G_ICxOepfS9jlz-e4SKWT9HmcgZI2uDcaoAJVes4lAZYtUPoezSeulbOiinGFrzRJUUuisaTLJ5YeSi3PxJywyzTEfvhiXktVYkQreUvqWXj0Fg0ecr07nu0Mmb9JZMSfKti0FAom4pF7LYl3QiS0R1pLqLDsz6rWFYUoy4OUvoz6THl4LxGJHCjMr_2IKFfz99XP2bBy9ZEuh15xzGsOWm5Vd1UMYu4UOe9OO8Wje0-ZjGizb01mFxfJ600EVnEIOk8yNqZXyZSkCiR4geyZcPAYT5p3tbTTLYJf8MdshR8s0PRUxeZiWb9sybsM5HWMnooj--2D6xZVgeSDgZR_AjZA8LxkEsTWIMCsu4bt1bi7FQAXNjEwWqYDGjYJoQ3V5VW1WsdjphQ0rUY7xe25B9mD7bDlBKzbkcrrRInefgK-Rr39Z9gJ2ugLJbxKpdOwNVxAnTj4-d-tBZNxgWjM2OsWvN4OaGuVtqSKekXvOojcgms0bMhmnh-J6EtDErfLf031f6WWSh5tQqx4gCXRtv3dBZc5cjRfJYsWuQ9pBJmtUTacQaZs1bvnSntL5XgCkcNp9acNKhzQyWrLQRx4RjCCOTbvFURTLM";
        public String FilmImage5 = "https://kinopoisk-ru.clstorage.net/1u5E8d200/53688eTPZN_/tdkFkP8oslsgVJ2zxqkNGjQQdtrc4uHZ4eTIdAwp-4hYDDtzqg3vFs7QMxFUi-DYZRGgIfvTHRj31fltlPhAbzXIEMc7b2SMd9OOcxE9mchyhqNem_D0SOagHyLb4jeCVIZn-iXH5x3WgaOC0V02DfUAt_bq0Ruc5IlgqQHnFnuzHgtev3W3m6wF23-JZEaUpRe2HEUmaxSwK4K7xq5zSFqPobelDOwbHM7kT0OeNcQ8xXZ3J9EFXuOLK3rOZh8-_9jOXLjzc5Msz1GwRiVE3KXaNRpBaerWu22CcwrhfgMaiio0YIys11_ArgZL1H2G8oi5tOxbSdVqQ-z9SmveN3XZjBZ9sPGXaIZQOkHqQdIm0fMSh2Hr0L5kyfLEI_HLXkLldG1NY9pfSmaOThsyR_XC9TcmVgVaKAzk84Jg2Lj1VQ5Qev_1W2QJFjlBog8WYt3yHs_m7Fa3bUq-TGB6xFmCZDGhi63WlY0ij8EWvUw8Qr8_Lp6DnmxHbrgJ4Fn6t1iJlnp4vZ9mgl7_DWDGlaLYtxRHZuPRcStI8cxluolSRSkxYsVlGpFIo47KEbpGNAV-9C8bQhwoQ2L1yiVVsvbYQVzxe_GQoUMScETkTZDrUrPRiyHpGLBvy3pMa3bBH0ehP-sBI5kdQO2FQ5x1zr0KNrqi2oUbpQAjME7q27G8Gc_Xvn-4UyDN2PKI7kYZJl4xHQaipZq4YoN1zWD5RhbK4nzvyGjWHMDjDQmdfwB8zfa8atjJnaBMZj2NpdI8fN9MUPB6s9YvQRu3j6EHF-rZfZROoCtdNONJfgalfYNaTW28a4zjldiBK87BlnCEvwm8sOLQBZwog-PyjOwWN7kYzZ--vjsZ704X8gQsRJglVnzRhKHlFbwqz35D67vIXg_lt-THrF_UT-sNSZO4hj-O8DUnV4KSL0dsOI0mHzr0n4YXt_Gwly0HUTiHqEWe79h2U4LlK530owZ6hKB0jFmPaTqog-pdE0yszMjS9gv9T_a0LlrLmyGIrLWJpRL7cdJOULa_eZRiwRq4SSWMHKfftNIMJmKY8eOJvgSoskLRj-q5K0hl1NbAIg3Knf5OusE09ONSRhKtQuX4Ba6Vsv7XAd26dz3RYg-VegBixhIqmbcWA2Pp1DDji3oKKTWEFQvlfejLIpJVjarBgRdyyPCGfP-q2widYgfufAPimTM4lM6efvky2O-LFnIEpQ9Uqlg7VYuhIp2xpcp9wekxCJHMajkvz6Bck4Dvz8GTtMB0AfT4YhaMnuhA7PgMZFa0ttAIUbF58V4oiZK9xKsNUCzSfdPOqq4efCSONoohcgsQAmy7LM0q1BmB4wGAX35M9g5_v2OfjRvoDCo9Ruwa-3-RSF73_T8SZUUWO0OpSNmn2TNVT6DtV7_nADJDJX3IUUSl8yoJJZEVxeYFQVw5yjQG_f0kFcpUYUimM8GllTK8GExdM7A02-RL2vlM44GUrZ9y105ppFc7K858BOyzi1XL7brvxS1a3gJlysNS_cUyzjk_YlqFHGxNK7VMb5LwfdYJUTOz_5iixNE_zmPHGC4bNltPq-KUuSsJds4ltYvXQmK84ozonxVPI8EGmfWEsko5_ySZRVRgz2QxySOW-b-Wwda-MbmeIAtY-olqTxErGHpaCqOpFjzoAXwDrTCLkQoususFKJXXzOwLjp12S7wGsb5qnUqRoAfkuEJlU3a4kUwX-zC7Vq3PXXLG5cFR7Z10UoXroh8wbEQygqbwwlCL4X2gBOBS2M7nCUsassw8CPYxI1CKEWXMLj9CLF44vdyPWLswshdsDh12TG2GWGwa-ppOJW2Z8O1L98pn_YxdT-41YkEuVFGFJsLAHDdN9Y61fa5RSJNiDa73RWdY-HRXRBp6tbCYIorYMs5ghlEmlzKdiSZmH7QsTL9OJn5BWc_ssuwMIpOcgS8DQVmwjjNAtz9rX0Md7UMiPIMlUXa0mAzVsb_4n-aC3jLHakceLRK9kgxloVE0r0ryh6_4C14AarqqSKwal83mDUOUvMfziLA4q5ENmOjCaXDMoBq4dhKMWnN5OluuAp21x6iMECsQfddGaiHY8G1LcQbg8kPZwiH8r0gjkhGEok0B176PN094-uXXDdnkxSp6xuDVMn8XCNX4fzLQZw_fcM5qiF6p3nVdRKei3LHnCHQB4DkMVYQh-mTA7BQdSWNOyxt3D3DNOHIkUYzcr4Au8EtrE_t218kU_XL73iTFWTrGZY7Wo5a204fv6ha3Zkp0jyxwwVpGLPRhCeqaEwiiw4jVusU-iD89r92JkmvHZHhMrxu5PRDJ3nt-_1isAxj7TqDJFO3Qc5mKK-KS-CJLfU4u_s4XjyTyJ0usHFuIo8KGH34LcgdxP21bhl2qD6fzROtefnkfxVBys_BSb0fVv4WsShFklfcbSm2p1_-rwD1M4HlIGEDhcO3N6N3fyGUKh5V0A_BN9bfgWEDeIoIqOwAkn_Z4H0jX-X8xUSCNWTIPIMZVYZlzVkShbFC-bsk6xK5zjxkM5bhizu4aVEhrAYefdUv0wLW8L11EmSqMbfWIIx-7N90BnXH7tZLig9IxzOIBl65XfJXPZqLVsaQMfkltMoldAGD6oAmindOHY8JAX3bIdgx0vmOewh7oQ-k1i2hRMnGdiRG3cDCbJk1RNgFiQlBpFj6Wymcj3rYvSTzM7jNA2YwtfCOOIlSUiaDFRhQ-SriBdfwrkQybKk3jOYSq2_A0kMuVffjznCcBmX0MLc8R7ZK3HUsi5RB7p4P1Sa89QlxIYPfiAaKdnUUrgk_adUI_xrg4YJ7Lk2BM47GC55rz_l3HXbZx9FBvB5HzRW1FHyRbMhZNq6KYsmaO-wqmuYtXheF1683jHZ_GpIdOXPHL8wz9tiOdxFmshSpwia8YMbAeA9j_-DCa7wWXO8QoTx6ulrKewy5qFrOuz71NLPvEmYKheKgN4hOVhC7KD14wADZAf3ljH0Rbok#DSD";
        public String FilmImage6 = "https://kinopoisk-ru.clstorage.net/1u5E8d200/53688eTPZN_/tdkFkP8oslsgVJ2zxqkNGjQQdtrc4uHZ4eTIdAwp-4hYDDtzqg3vFs7QMBMWyiJYZQU0tfsTiZj0Ve4tVrpAbyOdkQctu3HOd9Ia8tNoWAgzBaKJ23D0SOagHyLb4jeCVIZn-iXH5x3WgaOC0V02DfUAt_bq0Ruc5IlgqQHnFnuzHgtev3W3m6wF23-JZEaUpRe2HEUmaxSwK4K7xq5zSFqPobelDOwbHM7kT0OeNcQ8xXZ3J9EFXuOLK3rOZh8-_9jOXLjzc5Msz1GwRiVE3KXaNRpBaerWu22CcwrhfgMaiio0YIys11_ArgZL1H2G8oi5tOxbSdVqQ-z9SmveN3XZjBZ9sPGXaIZQOkHqQdIm0fMSh2Hr0L5kyfLEI_HLXkLldG1NY9pfSmaOThsyR_XC9TcmVgVaKAzk84Jg2Lj1VQ5Qev_1W2QJFjlBog8WYt3yHs_m7Fa3bUq-TGB6xFmCZDGhi63WlY0ij8EWvUw8Qr8_Lp6DnmxHbrgJ4Fn6t1iJlnp4vZ9mgl7_DWDGlaLYtxRHZuPRcStI8cxluolSRSkxYsVlGpFIo47KEbpGNAV-9C8bQhwoQ2L1yiVVsvbYQVzxe_GQoUMScETkTZDrUrPRiyHpGLBvy3pMa3bBH0ehP-sBI5kdQO2FQ5x1zr0KNrqi2oUbpQAjME7q27G8Gc_Xvn-4UyDN2PKI7kYZJl4xHQaipZq4YoN1zWD5RhbK4nzvyGjWHMDjDQmdfwB8zfa8atjJnaBMZj2NpdI8fN9MUPB6s9YvQRu3j6EHF-rZfZROoCtdNONJfgalfYNaTW28a4zjldiBK87BlnCEvwm8sOLQBZwog-PyjOwWN7kYzZ--vjsZ704X8gQsRJglVnzRhKHlFbwqz35D67vIXg_lt-THrF_UT-sNSZO4hj-O8DUnV4KSL0dsOI0mHzr0n4YXt_Gwly0HUTiHqEWe79h2U4LlK530owZ6hKB0jFmPaTqog-pdE0yszMjS9gv9T_a0LlrLmyGIrLWJpRL7cdJOULa_eZRiwRq4SSWMHKfftNIMJmKY8eOJvgSoskLRj-q5K0hl1NbAIg3Knf5OusE09ONSRhKtQuX4Ba6Vsv7XAd26dz3RYg-VegBixhIqmbcWA2Pp1DDji3oKKTWEFQvlfejLIpJVjarBgRdyyPCGfP-q2widYgfufAPimTM4lM6efvky2O-LFnIEpQ9Uqlg7VYuhIp2xpcp9wekxCJHMajkvz6Bck4Dvz8GTtMB0AfT4YhaMnuhA7PgMZFa0ttAIUbF58V4oiZK9xKsNUCzSfdPOqq4efCSONoohcgsQAmy7LM0q1BmB4wGAX35M9g5_v2OfjRvoDCo9Ruwa-3-RSF73_T8SZUUWO0OpSNmn2TNVT6DtV7_nADJDJX3IUUSl8yoJJZEVxeYFQVw5yjQG_f0kFcpUYUimM8GllTK8GExdM7A02-RL2vlM44GUrZ9y105ppFc7K858BOyzi1XL7brvxS1a3gJlysNS_cUyzjk_YlqFHGxNK7VMb5LwfdYJUTOz_5iixNE_zmPHGC4bNltPq-KUuSsJds4ltYvXQmK84ozonxVPI8EGmfWEsko5_ySZRVRgz2QxySOW-b-Wwda-MbmeIAtY-olqTxErGHpaCqOpFjzoAXwDrTCLkQoususFKJXXzOwLjp12S7wGsb5qnUqRoAfkuEJlU3a4kUwX-zC7Vq3PXXLG5cFR7Z10UoXroh8wbEQygqbwwlCL4X2gBOBS2M7nCUsassw8CPYxI1CKEWXMLj9CLF44vdyPWLswshdsDh12TG2GWGwa-ppOJW2Z8O1L98pn_YxdT-41YkEuVFGFJsLAHDdN9Y61fa5RSJNiDa73RWdY-HRXRBp6tbCYIorYMs5ghlEmlzKdiSZmH7QsTL9OJn5BWc_ssuwMIpOcgS8DQVmwjjNAtz9rX0Md7UMiPIMlUXa0mAzVsb_4n-aC3jLHakceLRK9kgxloVE0r0ryh6_4C14AarqqSKwal83mDUOUvMfziLA4q5ENmOjCaXDMoBq4dhKMWnN5OluuAp21x6iMECsQfddGaiHY8G1LcQbg8kPZwiH8r0gjkhGEok0B176PN094-uXXDdnkxSp6xuDVMn8XCNX4fzLQZw_fcM5qiF6p3nVdRKei3LHnCHQB4DkMVYQh-mTA7BQdSWNOyxt3D3DNOHIkUYzcr4Au8EtrE_t218kU_XL73iTFWTrGZY7Wo5a204fv6ha3Zkp0jyxwwVpGLPRhCeqaEwiiw4jVusU-iD89r92JkmvHZHhMrxu5PRDJ3nt-_1isAxj7TqDJFO3Qc5mKK-KS-CJLfU4u_s4XjyTyJ0usHFuIo8KGH34LcgdxP21bhl2qD6fzROtefnkfxVBys_BSb0fVv4WsShFklfcbSm2p1_-rwD1M4HlIGEDhcO3N6N3fyGUKh5V0A_BN9bfgWEDeIoIqOwAkn_Z4H0jX-X8xUSCNWTIPIMZVYZlzVkShbFC-bsk6xK5zjxkM5bhizu4aVEhrAYefdUv0wLW8L11EmSqMbfWIIx-7N90BnXH7tZLig9IxzOIBl65XfJXPZqLVsaQMfkltMoldAGD6oAmindOHY8JAX3bIdgx0vmOewh7oQ-k1i2hRMnGdiRG3cDCbJk1RNgFiQlBpFj6Wymcj3rYvSTzM7jNA2YwtfCOOIlSUiaDFRhQ-SriBdfwrkQybKk3jOYSq2_A0kMuVffjznCcBmX0MLc8R7ZK3HUsi5RB7p4P1Sa89QlxIYPfiAaKdnUUrgk_adUI_xrg4YJ7Lk2BM47GC55rz_l3HXbZx9FBvB5HzRW1FHyRbMhZNq6KYsmaO-wqmuYtXheF1683jHZ_GpIdOXPHL8wz9tiOdxFmshSpwia8YMbAeA9j_-DCa7wWXO8QoTx6ulrKewy5qFrOuz71NLPvEmYKheKgN4hOVhC7KD14wADZAf3ljH0Rbok";
    }
}