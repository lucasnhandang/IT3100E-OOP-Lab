package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.media.*;
import java.util.ArrayList;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia (Media media) {
        itemsOrdered.add(media);
    }

    public void removeMedia (Media media) {
        itemsOrdered.remove(media);
    }

    public float totalCost () {
        float ans = 0;
        for (Media media : itemsOrdered) {
            ans += media.getCost();
        }
        return ans;
    }

    public void searchById (int idMatch) {
        boolean dvdFound = false;
        for (Media dvd : itemsOrdered) {
            if (dvd.getId() == idMatch) {
                dvd.toString();
                dvdFound = true;
            }
        }
        if (!dvdFound) {
            System.out.println("Item not found.");
        }
    }

    public void searchByTitle (String titleMatch) {
        boolean dvdFound = false;
        for (Media dvd : itemsOrdered) {
            if(dvd instanceof DigitalVideoDisc) {
                if (((DigitalVideoDisc) dvd).isMatch(titleMatch)) {
                    dvd.toString();
                    dvdFound = true;
                }
            }
        }
        if (!dvdFound) {
            System.out.println("Item not found.");
        }
    }

    public void print () {
        System.out.println("***********************CART***********************");
        System.out.println("Items ordered: ");
        for (Media media: itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
}