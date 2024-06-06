package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.screen.manager.StoreManagerScreen;
import hust.soict.globalict.aims.store.Store;

public class TestStoreManagerScreen {
    public static void main (String[] args) {
        Store store = new Store();
        store.initData();
        new StoreManagerScreen(store);
    }
}
