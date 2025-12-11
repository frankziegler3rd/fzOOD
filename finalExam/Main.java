/**
 * OOD, professor chu
 * final exam
 *
 * main / client 
 *
 * @author frank ziegler
 * @version 1
 */

import model.*;
import service.*;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void printChart1UsingJSONData() {/*
        ChartGetter getter = new JSONSongsGetter();
        ChartCollection coll = getter.fetch();
        ChartIterator chit = new SongsIterator((SongCollection) coll);
        while(chit.hasNext()) {
            Song song = chit.next();
            System.out.format("%10d%32s%32s%32s", song.getRank(), song.getTitle(), song.getArtist(), song.getAlbum());
            if(song.getRank() == 25) break;
        }
        pl("");
    */}

    public static void printChart1UsingXMLData() {
        ChartGetter getter = new XMLSongsGetter();
        ChartCollection coll = getter.fetch();
        ChartIterator chit = new SongsIterator((SongCollection) coll);
        while(chit.hasNext()) {
            Song song = (Song) chit.next();
            System.out.format("%10d%32s%32s%32s\n", song.getRank(), song.getTitle(), song.getArtist(), song.getAlbum());
            if(song.getRank() == 25) break;
        }
        pl("");
    }

    public static void printChart2UsingJSONData() {

    }

    public static void printChart2UsingXMLData() {

    }

    /**
     * printing utilities to avoid typing "System.out.print[ln]
     */
    private static void pl(Object o) { System.out.println(o); }
    private static void p(Object o) { System.out.print(o); }

    public static void main(String[] args) {
        pl("+--------------------------------+");
        pl("|                                |");
        pl("|           welcome to           |");
        pl("|        itunes chart data       |");
        pl("|               🎵               |");
        pl("|         ood final exam         |");
        pl("|         frank ziegler          |");
        pl("|                                |");
        pl("+--------------------------------+");
        pl("");
        boolean quit = false;
        while (!quit) {
            pl("1. test printing chart 1 using the JSON data source");
            pl("2. test printing chart 1 using the XML data source");
            pl("3. test printing chart 2 using the JSON data source");
            pl("4. test printing chart 2 using the XML data source");
            pl("0. quit");
            p("choose an option: ");
            int menu = sc.nextInt(); pl(menu); sc.nextLine();
            switch(menu) {
                case 1:
                    printChart1UsingJSONData();
                    break;
                case 2:
                    printChart1UsingXMLData();
                    break;
                case 3:
                    printChart2UsingJSONData();
                    break;
                case 4:
                    printChart2UsingXMLData();
                    break;
                case 0:
                    quit = true;
                    pl("goodbye.");
                    break;
            }
        }
    }
}
