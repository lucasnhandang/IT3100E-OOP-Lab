package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;
    private int length;

    public DigitalVideoDisc(String name, String genre, String director, int length, double v) {
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    @Override
    public void play() throws PlayerException {
        if(this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
        else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    public boolean isMatch (String titleMatch) {
        return this.getTitle().equals(titleMatch);
    }

    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getLength() + " - " + this.getCost() + "$";
    }
}
