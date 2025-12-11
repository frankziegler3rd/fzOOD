/**
 * OOD, professor chu
 * final exam
 *
 * represents an album
 *
 * @author frank ziegler
 * @version 1
 */

package model;

import model.Song;
import java.util.List;
import java.util.ArrayList;

public class Album {

    private String title;
    private String artist;
    private List<Song> songs;
    private int rank;

    public Album(String title, String artist, int rank) {
        this.title = title;
        this.artist = artist;
        songs = new ArrayList<Song>();
        this.rank = rank;
    }

    public String getTitle() { return title; }
    
    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }

    public void setArtist(String artist) { this.artist = artist; }

    public List<Song> getSongs() { return songs; }

    public void setSongs(List<Song> songs) { this.songs = songs; }

    public int getRank() { return rank; }

    public void setRank(int rank) { this.rank = rank; }
}
