package com.hfad.spotify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MusicList> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        list.add(new MusicList("asd","1","Butter","방탄소년단"));
        list.add(new MusicList("asd","2","헤픈 우연","헤이즈 (Heize)"));
        list.add(new MusicList("asd","3","Dun Dun Dance","오마이걸 (OH MY GIRL)"));
        list.add(new MusicList("asd","4","Next Level","aespa"));
        list.add(new MusicList("asd","5","Peaches (Feat.Daniel Caesar & Giveon)","Justin Bieber"));

        SimpleTextAdapter adapter = new SimpleTextAdapter(list);
        Log.i("ItemCount" , "" + adapter.getItemCount());
        RecyclerView recyclerView = findViewById(R.id.recycler1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}