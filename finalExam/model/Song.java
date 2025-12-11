/**
 * OOD, professor chu
 * final exam
 *
 * represents a song
 *
 * @author frank ziegler
 * @version 1
 */

package model;

public class Song {

    private String title;
    private String artist;
    private String album;
    private int rank;

    public Song(String title, String artist, String album, int rank) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.rank = rank;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }

    public void setArtist(String artist) { this.artist = artist; }

    public String getAlbum() { return album; }

    public void setAlbum(String album) { this.album = album; }

    public int getRank() { return rank; }

    public void setRank(int rant) { this.rank = rank; }
}
