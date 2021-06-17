package com.hfad.spotify.activity;

import com.hfad.spotify.HttpUtil;
import com.hfad.spotify.MusicList;
import com.hfad.spotify.R;
import com.hfad.spotify.fragment.MusicBarFragment;
import com.hfad.spotify.db.DBHelper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MusicList> list;
    public static SQLiteDatabase sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper helper;
        SQLiteDatabase db;
        helper = new DBHelper(MainActivity.this, "newdb.db", null,2);
        db = helper.getWritableDatabase();
        helper.onCreate(db);
        this.sql = db;


            RecyclerView recyclerView = findViewById(R.id.recycler1);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        new HttpUtil(recyclerView).execute();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment  = new MusicBarFragment();
        transaction.add(R.id.frame,fragment);
        transaction.commit();

        }

}