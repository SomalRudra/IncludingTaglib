package com.example.nativetest;

public class Audiofileproperties {

    String songname="";
    String title="";
    String Album="";
    String Artist="";
    String Comment="";
    String genre="";
    String Albumartist="";
    String Subtitle="";
    int Tracknumber;
    int discnumber;
    int year;

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return Album;
    }

    public String getArtist() {
        return Artist;
    }

    public String getComment() {
        return Comment;
    }

    public String getGenre() {
        return genre;
    }

    public String getAlbumartist() {
        return Albumartist;
    }

    public String getSubtitle() {
        return Subtitle;
    }

    public int getTracknumber() {
        return Tracknumber;
    }

    public int getDiscnumber() {
        return discnumber;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAlbum(String album) {
        Album = album;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAlbumartist(String albumartist) {
        Albumartist = albumartist;
    }

    public void setSubtitle(String subtitle) {
        Subtitle = subtitle;
    }

    public void setTracknumber(int tracknumber) {
        Tracknumber = tracknumber;
    }

    public void setDiscnumber(int discnumber) {
        this.discnumber = discnumber;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
