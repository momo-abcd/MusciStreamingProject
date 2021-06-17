package com.hfad.spotify;

public class MusicList {
    private String elbumImg;
    private String rank;
    private String musicName;
    private String singerName;
    private String uuid;

    public MusicList(String elbumImg, String rank, String musicName, String singerName, String uuid) {
        this.elbumImg = elbumImg;
        this.rank = rank;
        this.musicName = musicName;
        this.singerName = singerName;
        this.uuid = uuid;
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
    public String getUuid() {
        return uuid;
    }
}