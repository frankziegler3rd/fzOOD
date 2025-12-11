/**
 * OOD, professor chu
 * final exam
 *
 * song collection iterator
 *
 * @author frank ziegler
 * @version 1
 */

package service;

import model.Album;
import service.AlbumCollection;

public class AlbumsIterator implements ChartIterator {

    private AlbumCollection ac;
    private int index;

    public AlbumsIterator(AlbumCollection ac) {
        this.ac = ac;
        index = 0;
    }

    public boolean hasNext() {
        return index < ac.size();
    }

    public Album next() {
        return ac.get(index++);
    }
}
