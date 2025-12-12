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

    public static void printChart1(ChartGetter cg, int maxSongRank) {
        ChartGetter getter = cg;
        ChartCollection coll = getter.fetch();
        ChartIterator chit = new SongsIterator((SongCollection) coll);
        printChartDivider();
        System.out.format("| %-7s | %-40s | %-40s | %-40s |%n", "rank", "title", "artist", "album");
        printChartDivider();
        while(chit.hasNext()) {
            Song song = (Song) chit.next();
            System.out.format(
                    "| %-7s | %-40s | %-40s | %-40s |%n", 
                    song.getRank(), 
                    trunc(song.getTitle(), 40), 
                    trunc(song.getArtist(), 40),
                    trunc(song.getAlbum(), 40)
            );
            if(song.getRank() == maxSongRank) break;
        }

        printChartDivider();
        pl("");
    }

    public static void printChart2(ChartGetter ag, ChartGetter sg, int maxAlbumRank, int maxSongRank) {
        ChartGetter albumsGetter = ag;
        ChartCollection acoll = albumsGetter.fetch();
        ChartIterator ait = new AlbumsIterator((AlbumCollection) acoll);
        ChartGetter songsGetter = sg;
        ChartCollection scoll = songsGetter.fetch();

        printChartDivider();
        System.out.format("| %-7s | %-40s | %-40s | %-40s |%n", "rank", "title", "artist", "songs in top 10");
        printChartDivider();
        while(ait.hasNext()) {
            Album album = (Album) ait.next();
            System.out.format(
                    "| %-7s | %-40s | %-40s ", 
                    album.getRank(), 
                    trunc(album.getTitle(), 40), 
                    trunc(album.getArtist(), 40)
            );

            ChartIterator sit = new SongsIterator((SongCollection) scoll);
            boolean found = false;
            while(sit.hasNext()) {
                Song song = (Song) sit.next();
                if(song.getAlbum().equalsIgnoreCase(album.getTitle())) {
                    if(!found) {
                        System.out.format(
                                "| %-40s |%n",
                                trunc(song.getTitle(), 40)
                        );
                    } else {
                        System.out.format(
                                "| %-7s | %-40s | %-40s | %-40s |%n", 
                                "",
                                "", 
                                "",
                                trunc(song.getTitle(), 40)
                        );
                    }
                    found = true;
                }
                if(song.getRank() == maxSongRank) break;
            }
            if(!found) {
                System.out.format(
                        "| %-40s |%n",
                        "(no songs in top 10)"
                );
            }

            if(album.getRank() == maxAlbumRank) break;
        }
        printChartDivider();
        pl("");
    }

    /**
     * printing and formatting utility methods
     */
    private static void pl(Object o) { System.out.println(o); }
    private static void p(Object o) { System.out.print(o); }
    private static String trunc(String s, int max) { return s.length() < max ? s : s.substring(0, max - 3) + "..."; }
    private static void printChartDivider() {
        p("+");
        for(int i = 0; i < 138; i++) p("-");
        pl("+");
    }

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

        pl("by default, chart 1 displays the top 10 songs, and chart 2 displays the top 10 albums and songs that are");
        pl("in those albums that are also in the top 10. you could customize this if you prefer.");
        pl("do you want to customize these parameters throughout your run of this application?");
        pl("1. yes");
        pl("2. no");
        p("choose an option: ");
        int customizationChoice = sc.nextInt(); pl(customizationChoice); sc.nextLine();
        boolean customize = customizationChoice == 1;
        if(customize) { pl("customization of parameters is ON"); } else { pl("customization of parameters is OFF"); }

        boolean quit = false;
        while (!quit) {

            pl("                         CHART 1 OPTIONS                          ");
            pl("1. print chart 1 using the JSON songs data");
            pl("2. print chart 1 using the XML songs data");
            pl("");
            pl("                         CHART 2 OPTIONS                          ");
            pl("3. print chart 2 using the JSON albums data and JSON songs data");
            pl("4. print chart 2 using the XML albums data and XML songs data");
            pl("5. print chart 2 using the JSON albums data and XML songs data");
            pl("6. print chart 2 using the XML albums data and the JSON songs data");
            pl("0. quit");
            p("choose an option: ");
            int menu = sc.nextInt(); pl(menu); sc.nextLine();

            int topXSongs = 10;
            int topXAlbums = 10;
            if(customize) {
                if(menu > 0 && menu < 3) {
                    p("display top X songs (type X as positive int): ");
                    topXSongs = sc.nextInt(); pl(topXSongs); sc.nextLine();
                } else if(menu > 2 && menu < 7) {
                    p("display top X albums (type X as positive int): ");
                    topXAlbums = sc.nextInt(); pl(topXAlbums); sc.nextLine();
                    p("display songs in album where song is in top X (type X as positive int): ");
                    topXSongs = sc.nextInt(); pl(topXAlbums); sc.nextLine();
                }
            }

            switch(menu) {
                case 1:
                    printChart1(new JSONSongsGetter(), topXSongs);
                    break;
                case 2:
                    printChart1(new XMLSongsGetter(), topXSongs);
                    break;
                case 3:
                    printChart2(new JSONAlbumsGetter(), new JSONSongsGetter(), topXAlbums, topXSongs);
                    break;
                case 4:
                    printChart2(new XMLAlbumsGetter(), new XMLSongsGetter(), topXAlbums, topXSongs);
                    break;
                case 5:
                    printChart2(new JSONAlbumsGetter(), new XMLSongsGetter(), topXAlbums, topXSongs);
                    break;
                case 6:
                    printChart2(new XMLAlbumsGetter(), new JSONSongsGetter(), topXAlbums, topXSongs);
                    break;
                case 0:
                    quit = true;
                    pl("goodbye.");
                    break;
            }
        }
    }
}
