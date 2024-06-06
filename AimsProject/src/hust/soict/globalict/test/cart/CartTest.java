package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.*;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.*;

import java.util.ArrayList;
import java.util.List;

public class CartTest {
    public static void main(String[] args) throws PlayerException {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        cart.addMedia(dvd3);

        List<String> authors = new ArrayList<String>();
        authors.add("Nhan Dang");
        Book book1 = new Book("S. Holmes", "Thriller", 100.12f, authors);
        cart.addMedia(book1);

        cart.toString();
        cart.print();
    }

}
