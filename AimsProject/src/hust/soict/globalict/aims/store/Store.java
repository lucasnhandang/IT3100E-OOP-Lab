package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.media.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia (Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
        }
    }

    public void removeMedia (Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
        }
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void display() {
        for (Media media: itemsInStore) {
            System.out.println(media);
        }
    }

    public void initData() {
        // 5 DigitalVideoDiscs
        addMedia(new DigitalVideoDisc("WWW Brothers", "Action", "The Matrix", 120));
        addMedia(new DigitalVideoDisc("Christopher Nolan", "Science Fiction", "Inception", 150));
        addMedia(new DigitalVideoDisc("Christopher Nolan", "Sci-Fi", "Inception", 19.99f));
        addMedia(new DigitalVideoDisc("Quentin Tarantino", "Drama", "Pulp Fiction", 14.99f));
        addMedia(new DigitalVideoDisc("Steven Spielberg", "Adventure", "Jurassic Park", 12.99f));
        addMedia(new DigitalVideoDisc("Peter Jackson", "Fantasy", "The Lord of the Rings", 14.99f));
        addMedia(new DigitalVideoDisc("James Cameron", "Sci-Fi", "Avatar", 19.99F));
        addMedia(new DigitalVideoDisc("Stanley Kubrick", "Drama", "The Shining", 14.99f));
        addMedia(new DigitalVideoDisc("Alfred Hitchcock", "Thriller", "Psycho", 14.99f));
        addMedia(new DigitalVideoDisc("Francis Ford Coppola", "Crime", "The Godfather", 14.99f));
        addMedia(new DigitalVideoDisc("Steven Spielberg", "Sci-Fi", "E.T. the Extra-Terrestrial", 14.99f));
        addMedia(new DigitalVideoDisc("George Lucas", "Sci-Fi", "Star Wars: Episode IV - A New Hope", 14.99f));

        // 5 books
        addMedia(new Book("A Brief History of Time", "Science", 15.99f, Collections.singletonList("Stephen Hawking")));
        addMedia(new Book("1984", "Dystopian", 12.99f, Collections.singletonList("George Orwell")));
        addMedia(new Book("To Kill a Mockingbird", "Classic", 9.99f, Collections.singletonList("Harper Lee")));
        addMedia(new Book("The Catcher in the Rye", "Classic", 8.99f, Collections.singletonList("J.D. Salinger")));
        addMedia(new Book("The Great Gatsby", "Fiction", 10.99f, Collections.singletonList("F. Scott Fitzgerald")));

        // 5 CompactDiscs
        // tracks
        Track track1 = new Track("Song One", 180);
        Track track2 = new Track("Song Two", 200);
        Track track3 = new Track("Song Three", 240);
        Track track4 = new Track("Song Four", 220);
        Track track5 = new Track("Song Five", 210);
        // CDs
        addMedia(new CompactDisc(1, "Greatest Hits", "Pop", 14.99f, "John Doe", "Artist One", Arrays.asList(track1, track2)));
        addMedia(new CompactDisc(2, "Classical Favorites", "Classical", 19.99f, "Jane Smith", "Artist Two", Arrays.asList(track3, track4)));
        addMedia(new CompactDisc(3, "Rock Anthems", "Rock", 9.99f, "Alice Johnson", "Artist Three", Arrays.asList(track1, track3, track5)));
        addMedia(new CompactDisc(4, "Jazz Classics", "Jazz", 12.99f, "Bob Brown", "Artist Four", Arrays.asList(track2, track4)));
        addMedia(new CompactDisc(5, "Hip Hop Beats", "Hip Hop", 11.99f, "Chris Green", "Artist Five", Arrays.asList(track1, track2, track3, track4, track5)));

        CompactDisc cd = new CompactDisc(69, "HARD", "Music", 250508f, "SHINee");
        Track t1 = new Track("HARD", 123);
        Track t2 = new Track("Juice", 123);
        Track t3 = new Track("The Feeling", 123);
        Track t4 = new Track("Like It", 123);
        Track t5 = new Track("10X", 123);
        cd.addTrack(t1);
        cd.addTrack(t2);
        cd.addTrack(t3);
        cd.addTrack(t4);
        cd.addTrack(t5);
        addMedia(cd);
    }
}