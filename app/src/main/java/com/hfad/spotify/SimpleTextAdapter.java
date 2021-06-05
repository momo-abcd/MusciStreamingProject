package com.hfad.spotify;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.Holder>  {
    private ArrayList<MusicList> mData = null;

    SimpleTextAdapter(ArrayList<MusicList> list) {
        this.mData = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view  = inflater.inflate(R.layout.recyclerview_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
//        Bitmap imgBitmap = null;
//        try {
//            InputStream in = new URL(mData.get(position).getElbumImg()).openStream();
//            imgBitmap = BitmapFactory.decodeStream(in);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Log.i("Hellow",mData.get(position).getElbumImg());
//        holder.elbumImg.setImageBitmap(imgBitmap);
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
        public Holder(View itemView) {
            super(itemView);
            elbumImg = itemView.findViewById(R.id.elbumImg);
            rankText = itemView.findViewById(R.id.rankText);
            musicNameText = itemView.findViewById(R.id.musicNameText);
            singerNameText = itemView.findViewById(R.id.singerNameText);
        }
    }
}
