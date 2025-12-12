/**
 * OOD, professor chu
 * final exam
 * 
 * collection of albums
 *
 * @author frank ziegler
 * @version 1
 */

package service;

import model.Album;
import service.AlbumsIterator;
import java.util.List;

public class AlbumCollection implements ChartCollection {

    private List<Album> albums;

    public AlbumCollection(List<Album> albums) {
        this.albums = albums;
    }

    public void add(Album album) {
        albums.add(album);
    }

    public Album get(int index) {
        return albums.get(index);
    }

    public int size() {
        return albums.size();
    }

    @Override
    public ChartIterator iterator() {
        return new AlbumsIterator(this);
    }
}
