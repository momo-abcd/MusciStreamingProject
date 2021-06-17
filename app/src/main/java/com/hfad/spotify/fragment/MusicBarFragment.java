package com.hfad.spotify.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.hfad.spotify.activity.PlaylistActivity;
import com.hfad.spotify.R;

public class MusicBarFragment extends Fragment {
    public MusicBarFragment() {
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_music_bar,container,false);

        // 재생목록 버튼 클릭시 이벤트 처리
        ImageButton playListBtn = view.findViewById(R.id.playListBtn);
        playListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), PlaylistActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

//    @Override
//    public void onClick(View v) {
//        Log.i("myData666",""+R.id.playListBtn);
//        Log.i("myData667",""+v.getId());
//
//        switch (v.getId()) {
//            case R.id.playListBtn:
//                Toast.makeText(getActivity().getApplicationContext(),"" + v.getId(),Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getActivity().getApplicationContext(), PlaylistActivity.class);
//                startActivity(intent);
//                break;
//            default:
//                Log.i("myData666","Hellow");
//
//        }
//    }
}