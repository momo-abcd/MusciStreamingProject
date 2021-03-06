package com.hfad.spotify.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE if not exists currentPlaylist ("
                + "uuid text primary key,"
                + "name text,"
                + "artist text" + ");";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String sql = "DROP TABLE if exists currentPlaylist";

        if(newVersion > oldVersion) {

            db.execSQL("ALTER TABLE currentPlaylist ADD COLUMN imgUrl text");
            onCreate(db);
        }
    }
}
