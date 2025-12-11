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

public abstract class ChartGetter<T> {

    public ChartCollection fetch() {
        String raw = download(getUrl());
        T parsed = parse(raw);
        return extract(parsed);
    }

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

    public abstract String getUrl();

    public abstract T parse(String raw);

    public abstract ChartCollection extract(T parsed);
}
