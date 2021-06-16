package com.hfad.spotify.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.hfad.spotify.R;

public class MusicBarFragment extends Fragment {
    public MusicBarFragment() {
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_music_bar,container,false);

//        return view;
        return view;
    }
}