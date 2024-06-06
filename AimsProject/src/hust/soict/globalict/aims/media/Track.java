package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

import java.util.Objects;

public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    public Track(String title) {
        this.title = title;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public void play () throws PlayerException {
        if(this.length > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        }
        else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Track) {
            Track track = (Track) o;
            return (Objects.equals(track.getTitle(), this.getTitle()) &&
                    track.getLength() == this.getLength());
        }
        else {
            return false;
        }
    }
}
