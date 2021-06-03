package com.hfad.spotify;

public class MusicList {
    private String elbumImg;
    private String rank;
    private String musicName;
    private String singerName;

    public MusicList(String elbumIng, String rank, String musicName, String singerName) {
        this.elbumImg = elbumIng;
        this.rank = rank;
        this.musicName = musicName;
        this.singerName = singerName;
    }

    public String getElbumImg() {
        return elbumImg;
    }

    public String getRank() {
        return rank;
    }

    public String getMusicName() {
        return musicName;
    }

    public String getSingerName() {
        return singerName;
    }
}