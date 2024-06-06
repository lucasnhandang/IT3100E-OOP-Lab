package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.*;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.*;

import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Aims {
    private static Scanner scanner = new Scanner(System.in);
    public static Store store = new Store();
    public static Cart cart = new Cart();

    public static void showMenu () throws PlayerException {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option){
            case 1:
                viewStore();
                break;
            case 2:
                updateStore();
                break;
            case 3:
                seeCurrentCart();
                break;
            case 0:
                System.out.println("Exit...");
                break;
        }
    }

    // Option 1: View store
    private static void viewStore() throws PlayerException {
        System.out.println("-------------STORE--------------");
        for (Media item : store.getItemsInStore()){
            System.out.println(item);
        }
        System.out.println("--------------------------------");
        storeMenu();
    }
    public static void storeMenu() throws PlayerException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option){
            case 1:
                seeMediaDetail();
                break;
            case 2:
                addMediaToCart();
                break;
            case 3:
                playMedia();
                break;
            case 4:
                seeCurrentCart();
                break;
            case 0:
                System.out.println("Back to the first menu...");
                showMenu();
                break;
        }
        storeMenu();
    }
    private static void seeMediaDetail() throws PlayerException {
        System.out.println("Enter title of media: ");
        String title = scanner.nextLine();
        boolean isInStore = false;
        for (Media media: store.getItemsInStore()){
            if (media.getTitle().equals(title)){
                isInStore = true;
                System.out.println(media);
                mediaDetailsMenu(media);
            }
        }
        if (!isInStore) {
            System.out.println("This media is not in the store.");
        }
    }
    public static void mediaDetailsMenu (Media media) throws PlayerException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                cart.addMedia(media);
                break;
            case 2:
                if (media instanceof CompactDisc){
                    CompactDisc castMedia = (CompactDisc) media;
                    try {
                        castMedia.play();
                    } catch (PlayerException e) {
                        e.printStackTrace();
                    }
                }
                else if (media instanceof DigitalVideoDisc){
                    DigitalVideoDisc castMedia = (DigitalVideoDisc) media;
                    try {
                        castMedia.play();
                    } catch (PlayerException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println("This media can not display.");
                    mediaDetailsMenu(media);
                }
                break;
            case 0:
                break;
        }
        storeMenu();
    }

    private static void addMediaToCart() throws PlayerException {
        for (Media media: store.getItemsInStore()) {
            System.out.println(media);
        }
        System.out.println("Enter title of media to add: ");
        String usrTitle = scanner.nextLine();
        boolean isInStore = false;
        for (Media media: store.getItemsInStore()) {
            if (media.getTitle().equals(usrTitle)) {
                cart.addMedia(media);
                isInStore = true;
            }
        }
        if (!isInStore){
            System.out.println("This is not a valid title.");
        }
        storeMenu();
    }
    private static void playMedia() throws PlayerException {
        System.out.println("Enter the title of media to play: ");
        String usrTitle = scanner.nextLine();
        boolean isInStore = false;
        for (Media media: store.getItemsInStore()) {
            if (media.getTitle().equals(usrTitle)){
                isInStore = true;
                if (media instanceof CompactDisc){
                    CompactDisc castMedia = (CompactDisc) media;
                    castMedia.play();
                }
                else if (media instanceof DigitalVideoDisc){
                    DigitalVideoDisc castMedia = (DigitalVideoDisc) media;
                    castMedia.play();
                }
                else {
                    System.out.println("This media can not play");
                }
            }
        }
        if (!isInStore){
            System.out.println("Can not find media with this title");
        }
        storeMenu();
    }

    // Option 2: Update store in showMenu()
    private static void updateStore() throws PlayerException {
        //System.out.println("[Update store]");
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("Choose a number:");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                addMediaToStore();
                break;
            case 2:
                removeMediaStore();
                break;
            case 0:
                System.out.println("Back to main menu...");
                showMenu();
                break;
        }
    }
    // 2.1
    public static void addMediaToStore() throws PlayerException {
        //System.out.println("[Add a media to store]");
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Book");
        System.out.println("2. DigitalVideoDisc");
        System.out.println("3. CompactDisc");
        System.out.println("0. Back");

        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter id of media: ");
        int id = scanner.nextInt();
        System.out.println("Enter title of media: ");
        String title = scanner.nextLine();
        System.out.println("Enter category of media: ");
        String category = scanner.nextLine();
        System.out.println("Enter cost of media: ");
        float cost = scanner.nextFloat();

        switch (option) {
            case 1:
                System.out.println("Enter the number of authors: ");
                int num = scanner.nextInt();
                List<String> authors = new ArrayList<String>();
                for (int i = 0; i < num; ++i) {
                    String author = scanner.nextLine();
                    authors.add(author);
                }
                scanner.nextLine();
                Book addBook = new Book(title, category, cost, authors);
                store.addMedia(addBook);
                break;
            case 2:
                System.out.println("Enter director of media: ");
                String director = scanner.nextLine();
                scanner.nextLine();
                DigitalVideoDisc addDVD = new DigitalVideoDisc(title, category, director, cost);
                store.addMedia(addDVD);
                break;
            case 3:
                System.out.println("Enter artist of media: ");
                String artist = scanner.nextLine();
                scanner.nextLine();
                CompactDisc addCompactDisc = new CompactDisc(id, title, category, cost, artist);
                store.addMedia(addCompactDisc);
                break;
            case 0:
                showMenu();
        }
    }
    // 2.2
    public static void removeMediaStore() throws PlayerException {
        store.display();
        System.out.println("Enter id of media to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean isInStore = false;
        for (Media media: store.getItemsInStore()){
            if (media.getId() == id){
                isInStore = true;
                store.removeMedia(media);
            }
        }
        if (!isInStore) {
            System.out.println("Can not find media with id = " + id);
        }
        updateStore();
    }

    // Option 3: See cur. cart in showMenu()
    private static void seeCurrentCart() throws PlayerException {
        cart.print();
        cartMenu();
    }

    public static void cartMenu() throws PlayerException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");

        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                filterMedia();
                break;
            case 2:
                sortMedia();
                break;
            case 3:
                removeMediaFromCart();
                break;
            case 4:
                playMediaInCart();
                break;
            case 5:
                placeOrder();
                break;
            case 0:
                System.out.println("Back to show menu...");
                showMenu();
                break;
        }
        cartMenu();
    }
    public static void filterMedia() throws PlayerException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option){
            case 1:
                System.out.println("Enter media's id:");
                int id = scanner.nextInt();
                cart.searchById(id);
                break;
            case 2:
                System.out.println("Enter media's title:");
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                break;
            case 0:
                break;
        }
        cartMenu();
    }
    public static void sortMedia() throws PlayerException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by id");
        System.out.println("2. Sort by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                cart.print();
                break;

            case 2:
                Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                cart.print();
                break;
            case 0:
                break;
        }
        cartMenu();
    }
    public static void removeMediaFromCart() throws PlayerException {
        cart.print();
        System.out.println("Enter id of media in cart to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean isinCart = false;
        for (Media media: cart.getItemsOrdered()){
            if (media.getId() == id){
                isinCart = true;
                cart.removeMedia(media);
            }
        }
        if (!isinCart) {
            System.out.println("Can not find media with id = " + id);
        }
        cartMenu();
    }
    public static void playMediaInCart () throws PlayerException {
        cart.print();
        System.out.println("Enter id of media in cart to play: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean isInCart = false;
        for (Media media: cart.getItemsOrdered()) {
            if (media.getId() == id){
                if (media instanceof CompactDisc){
                    CompactDisc castMedia = (CompactDisc) media;
                    try {
                        castMedia.play();
                    } catch (PlayerException e) {
                        e.printStackTrace();
                    }
                }
                else if (media instanceof DigitalVideoDisc){
                    DigitalVideoDisc castMedia = (DigitalVideoDisc) media;
                    try {
                        castMedia.play();
                    } catch (PlayerException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println("Media with this id is not playable.");
                }
            }
        }
        if (!isInCart){
            System.out.println("Can not find media with id = " + id + " to play.");
        }
        cartMenu();
    }
    public static void placeOrder(){
        System.out.println("An order is created for you.");
        cart = new Cart();
    }

    // TEST
    public static void main(String[] args) throws PlayerException {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation",
                "Aladin", 18.99f);
        store.addMedia(dvd3);

        showMenu();
    }
}
