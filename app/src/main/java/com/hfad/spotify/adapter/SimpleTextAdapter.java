package com.hfad.spotify.adapter;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.hfad.spotify.activity.MainActivity;
import com.hfad.spotify.MusicList;
import com.hfad.spotify.R;

import java.util.ArrayList;

public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.Holder>  {
    private ArrayList<MusicList> mData = null;

    public SimpleTextAdapter(ArrayList<MusicList> list) {
        this.mData = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view  = inflater.inflate(R.layout.recyclerview_item,parent,false);
        return new Holder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Log.i("Hellow",mData.get(position).getElbumImg());

        Log.i("myData123123123",mData.get(position).getElbumImg());
//        Glide.with(holder.context).load("http://121.146.42.126:3008/images/happenImg.jpg").into(holder.elbumImg);
        Glide.with(holder.context).load("http://" + mData.get(position).getElbumImg()).into(holder.elbumImg);
        holder.singerNameText.setText(mData.get(position).getSingerName());
        holder.musicNameText.setText(mData.get(position).getMusicName());
        holder.rankText.setText(mData.get(position).getRank());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView elbumImg;
        TextView rankText;
        TextView musicNameText;
        TextView singerNameText;
        Context context;
        public Holder(View itemView,Context context) {
            super(itemView);
            elbumImg = itemView.findViewById(R.id.elbumImg);
            rankText = itemView.findViewById(R.id.rankText);
            musicNameText = itemView.findViewById(R.id.musicNameText);
            singerNameText = itemView.findViewById(R.id.singerNameText);
            this.context = context;

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int pos = getAdapterPosition();
//                    if (pos != RecyclerView.NO_POSITION){
//                        MusicList item = mData.get(pos);
//                        Log.i("myData9509", item.getUuid()+"");
//                        Log.i("myData9510", v+"");
//                        Log.i("myData9511", item+"");
//                    }
//
//                }
//            });
            itemView.findViewById(R.id.playBtn).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        MusicList item = mData.get(pos);
                        ContentValues values = new ContentValues();
                        values.put("uuid", item.getUuid());
                        values.put("name", item.getMusicName());
                        values.put("aritst", item.getSingerName());
                        MainActivity.sql.insert("currentPlaylist",null,values);
                        Cursor c = MainActivity.sql.query("currentPlaylist",null,null,null,null,null,null,null);
                        Log.i("myData9509", item.getUuid()+"");
                    }
                }
            });
        }
    }
}
