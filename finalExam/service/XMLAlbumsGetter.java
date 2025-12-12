/**
 * OOD, professor chu
 * final exam
 *
 * albums collector using XML data source
 *
 * @author frank ziegler
 * @version 1
 */

package service;

import model.Album;
import service.AlbumCollection;
import java.util.List;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import java.io.StringReader;
import java.lang.Exception;
import java.lang.RuntimeException;

public class XMLAlbumsGetter extends ChartGetter<Document> {

    private final String url;

    public XMLAlbumsGetter() {
        url = "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topalbums/limit=25/xml";
    }

    public String getUrl() { return url; }

    @Override
    public Document parse(String raw) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document parsedXML = builder.parse(new InputSource(new StringReader(raw)));
            return parsedXML;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AlbumCollection extract(Document parsed) {
        AlbumCollection ac = new AlbumCollection(new ArrayList<Album>());
        NodeList entries = parsed.getElementsByTagName("entry");
        int entriesLength = entries.getLength();
        for(int i = 0; i < entriesLength; i++) {
            Element entry = (Element) entries.item(i);
            String title = entry.getElementsByTagName("im:name")
                                .item(0)
                                .getTextContent();
            String artist = entry.getElementsByTagName("im:artist")
                                .item(0)
                                .getTextContent();
            ac.add(new Album(title, artist, i + 1));
        }
        
        return ac;
    }
}
