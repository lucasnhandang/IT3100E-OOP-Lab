package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public int getQtyOrdered() {
        return itemsOrdered.size();
    }

    public void addMedia(Media media){
        for (Media item : itemsOrdered){
            if (media.equals(item)){
                System.out.println("The media is already in the cart.");
                return;
            }
        }
        itemsOrdered.add(media);
        System.out.println("The media is added successfully.");
    }

    public void removeMedia(Media media) {
        if(itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        }
        else {
            for(Object t : itemsOrdered) {
                if(t.equals(media)) {
                    itemsOrdered.remove(media);
                    System.out.println("The media is removed successfully.");
                    return;
                }
            }
            System.out.println("The media can't be removed since it's not in the cart.");
        }
    }

    public void placeOrder() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            itemsOrdered.clear();
            System.out.println("Order is placed successfully.");
        }
    }

    public void deleteAll() {
        itemsOrdered.clear();
        System.out.println("The cart is empty.");
    }

    public float totalCost () {
        float ans = 0;
        for (Media media : itemsOrdered) {
            ans += media.getCost();
        }
        return ans;
    }

    public Media searchById(int i) {
        if(i < itemsOrdered.size()) {
            int index = 0;
            for(Media media : itemsOrdered) {
                index++;
                if(index == i) {
                    return media;
                }
            }
        }
        return null;
    }

    public Media searchByTitle(String title) {
        for(Media media : itemsOrdered) {
            if(media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public void searchByCategory(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the category that you want to search for: ");
        String category = scanner.nextLine();
        boolean found = false;
        for (Media media : itemsOrdered){
            if ((media.getCategory()).equals(category)){
                System.out.println("Found " + media);
                found = true;
            }
        }
        if (found == false){
            System.out.println("There is no DVD with the category '" + category + "'");
        }
    }

    public void sortMediaByTitle() throws PlayerException {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        this.print();
    }
    public void sortMediaByCost() throws PlayerException {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        this.print();
    }

    public void print () throws PlayerException {
        System.out.println("***********************CART***********************");
        System.out.println("Items ordered: ");
        for (Media media: itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
}