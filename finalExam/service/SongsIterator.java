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

import model.Song;
import service.SongCollection;

public class SongsIterator implements ChartIterator {

    private SongCollection sc;
    private int index;

    public SongsIterator(SongCollection sc) {
        this.sc = sc;
        index = 0;
    }

    public boolean hasNext() {
        return index < sc.size();
    }

    public Song next() {
        return sc.get(index++);
    }
}
