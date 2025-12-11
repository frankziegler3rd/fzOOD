/**
 * OOD, professor chu
 * final exam
 *
 * collection of songs
 *
 * @author frank ziegler
 * @version 1
 */

package service;

import model.Song;
import service.SongsIterator;
import java.util.List;

public class SongCollection implements ChartCollection {

    private List<Song> songs;

    public SongCollection(List<Song> songs) {
        this.songs = songs;
    }

    public void add(Song song) {
        songs.add(song);
    }

    public Song get(int index) {
        return songs.get(index);
    }

    public int size() {
        return songs.size();
    }

    @Override
    public ChartIterator iterator() {
        return new SongsIterator(this);
    }
}
