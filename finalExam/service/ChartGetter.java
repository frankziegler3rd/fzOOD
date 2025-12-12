/**
 * OOD, professor chu
 * final exam
 *
 * generic chart collector
 *
 * @author frank ziegler
 * @version 1
 */

package service;

import service.ChartCollection;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;
import java.lang.InterruptedException;
import java.io.IOException;
import java.lang.RuntimeException;

/**
 * uses a generic type T because Object cannot be overridden with the parsed classes (Document, JSONObject, etc.)
 */
public abstract class ChartGetter<T> {
    
    /**
     * the template method
     */
    public ChartCollection fetch() {
        String raw = download(getUrl());
        T parsed = parse(raw);
        return extract(parsed);
    }

    /**
     * connects to data source via URL, makes a GET request, saves the response body as the raw string data.
     */
    public String download(String urlStr) {
        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest req = HttpRequest.newBuilder().uri(URI.create(urlStr)).build();
            HttpResponse<String> resp = client.send(req, BodyHandlers.ofString());
            return resp.body();
        } catch(IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * each "getter" requires its own URL. that's why this method.
     */
    public abstract String getUrl();

    /**
     * we're dealing with two different formats of data: XML and JSON. they must be parsed differently thus this method needs to be implemented at the subclass level.
     */
    public abstract T parse(String raw);

    /**
     * we're dealing with two different types of collection: songs and albums. they must be extracted differently thus this method needs to be implemented at the subclass level. 
     */
    public abstract ChartCollection extract(T parsed);
}
