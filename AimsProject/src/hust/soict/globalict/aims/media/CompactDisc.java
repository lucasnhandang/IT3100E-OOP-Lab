package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private String director;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
    }

    public String getArtist() {
        return artist;
    }
    public CompactDisc(int id, String title, String category, float cost, String director, String artist,
                       List<Track> tracks) {
        super(id, title, category, cost);
        this.director = director;
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String artist, List<Track> tracks) {
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost);
        this.artist = artist;
    }

    public void addTrack (Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack (Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        }
    }

    public int getLength () {
        int len = 0;
        for (Track track : tracks) {
            len += track.getLength();
        }
        return len;
    }

    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist() + " - " + this.getLength() + " - " + this.getCost() + "$";
    }

    @Override
    public void play() throws PlayerException{
        if(this.getLength() > 0) {
            java.util.Iterator iter = tracks.iterator();
            Track nextTrack;
            while(iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                }
                catch (PlayerException e) {
                    throw e;
                }
            }
        }
        else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
}
