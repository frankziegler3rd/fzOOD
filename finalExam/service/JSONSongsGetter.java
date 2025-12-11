/**
 * OOD, professor chu
 * final exam
 *
 * songs collector using JSON data source 
 *
 * @author frank ziegler
 * @version 1
 */

package service;

import model.Song;
import service.SongCollection;
import org.json.JSONObject;
import org.json.JSONArray;
import java.lang.RuntimeException;
import java.util.List;
import java.util.ArrayList;

public class JSONSongsGetter extends ChartGetter<JSONObject> {

    private final String url;

    public JSONSongsGetter() {
        url = "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit=100/json";
    }

    public String getUrl() { return url; }

    @Override
    public JSONObject parse(String raw) {
        return new JSONObject(raw);
    }

    @Override
    public SongCollection extract(JSONObject parsed) {
        SongCollection sc = new SongCollection(new ArrayList<>());

        JSONArray entries = parsed.getJSONObject("feed").getJSONArray("entry");
        int entriesLength = entries.length();
        for(int i = 0; i < entriesLength; i++) {
            JSONObject entry = entries.getJSONObject(i);
            String title = entry.getJSONObject("im:name")
                                .getString("label");
            String artist = entry.getJSONObject("im:artist")
                                .getString("label");
            String album = entry.getJSONObject("im:collection")
                                .getJSONObject("im:name")
                                .getString("label");
            Song song = new Song(title, artist, album, i + 1);
            sc.add(song);
        }
        return sc;
    }
}
