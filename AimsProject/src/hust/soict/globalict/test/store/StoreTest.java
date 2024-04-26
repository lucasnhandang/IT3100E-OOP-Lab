package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.*;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("abcxyz", "asdasd", "dasad", 100, 10f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("TWICE", "Pop", "TWICE", 100, 1000f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.display();
    }
}