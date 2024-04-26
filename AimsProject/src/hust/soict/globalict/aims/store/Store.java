package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.media.*;
import java.util.ArrayList;

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
}