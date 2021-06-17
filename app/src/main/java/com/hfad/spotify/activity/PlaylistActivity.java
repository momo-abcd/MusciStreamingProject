package com.hfad.spotify.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.hfad.spotify.MusicList;
import com.hfad.spotify.R;
import com.hfad.spotify.adapter.PlaylistAdapter;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        ImageButton closeBtn = findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ArrayList<MusicList> list  = new ArrayList<>();

        @SuppressLint("Recycle") Cursor cursor = MainActivity.sql.rawQuery("SELECT * FROM currentPlaylist",null);
        while(cursor.moveToNext()) {
            String url = cursor.getString(cursor.getColumnIndex("imgUrl"));
            String musicName = cursor.getString(cursor.getColumnIndex("name"));
            String artist = cursor.getString(cursor.getColumnIndex("artist"));
            String uuid = cursor.getString(cursor.getColumnIndex("uuid"));

            list.add(new MusicList(url,"-",musicName,artist,uuid));
        }

        RecyclerView recyclerView = findViewById(R.id.playlistRecycler);
        PlaylistAdapter adapter = new PlaylistAdapter(list,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}