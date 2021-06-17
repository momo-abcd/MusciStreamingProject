package com.hfad.spotify.adapter;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hfad.spotify.MusicList;
import com.hfad.spotify.R;

import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.Holder> {
    ArrayList<MusicList> mData;
    Context context;

    public PlaylistAdapter(ArrayList<MusicList> list,Context context) {
        this.mData = list;
        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public PlaylistAdapter.Holder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recyclerview_playlist,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull PlaylistAdapter.Holder holder, int position) {
        Log.i("yang1",""+ mData.get(position).getMusicName());
        Log.i("yang2",""+ mData.get(position).getSingerName());
        Glide.with(context).load("http://" + mData.get(position).getElbumImg()).into(holder.elbumImg);
        holder.musicName.setText(mData.get(position).getMusicName());
        holder.singerName.setText(mData.get(position).getSingerName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView elbumImg;
        TextView musicName;
        TextView singerName;

        public Holder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            elbumImg = itemView.findViewById(R.id.playlistImg);
            musicName = itemView.findViewById(R.id.musicName);
            singerName = itemView.findViewById(R.id.singerName);
        }
    }
}
