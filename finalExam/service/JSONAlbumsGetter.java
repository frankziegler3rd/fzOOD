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

import model.Album;
import service.AlbumCollection;
import org.json.JSONObject;
import org.json.JSONArray;
import java.lang.RuntimeException;
import java.util.List;
import java.util.ArrayList;

public class JSONAlbumsGetter extends ChartGetter<JSONObject> {

    private final String url;

    public JSONAlbumsGetter() {
        url = "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topalbums/limit=25/json";
    }

    public String getUrl() { return url; }

    @Override
    public JSONObject parse(String raw) {
        return new JSONObject(raw);
    }

    @Override
    public AlbumCollection extract(JSONObject parsed) {
        AlbumCollection ac = new AlbumCollection(new ArrayList<>());

        JSONArray entries = parsed.getJSONObject("feed").getJSONArray("entry");
        int entriesLength = entries.length();
        for(int i = 0; i < entriesLength; i++) {
            JSONObject entry = entries.getJSONObject(i);
            String title = entry.getJSONObject("im:name")
                                .getString("label");
            String artist = entry.getJSONObject("im:artist")
                                .getString("label");
            Album album = new Album(title, artist, i + 1);
            ac.add(album);
        }
        return ac;
    }
}
