package com.hfad.spotify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MusicList> list;
    private TextView asdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);

        asdf = (TextView) findViewById(R.id.http);
//        list = new ArrayList<>();
//        list.add(new MusicList("asd","1","Butter","방탄소년단"));
//        list.add(new MusicList("asd","2","헤픈 우연","헤이즈 (Heize)"));
//        list.add(new MusicList("asd","3","Dun Dun Dance","오마이걸 (OH MY GIRL)"));
//        list.add(new MusicList("asd","4","Next Level","aespa"));
//        list.add(new MusicList("asd","5","Peaches (Feat.Daniel Caesar & Giveon)","Justin Bieber"));

//        SimpleTextAdapter adapter = new SimpleTextAdapter(list);
        RecyclerView recyclerView = findViewById(R.id.recycler1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);

//        asdf.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                new HttpUtil(recyclerView).execute();
//            }
//        });
            new HttpUtil(recyclerView).execute();

        }

}