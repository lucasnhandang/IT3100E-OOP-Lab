public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public void addDigitalVideoDisc (DigitalVideoDisc disc) {
        if(qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Please remove some discs to continue.");
        }
        else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
            if(qtyOrdered >= 18)
                System.out.println("The cart is almost full.");
        }
    }

    public void removeDigitalVideoDisc (DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; ++i) {
            if(itemsOrdered[i] == disc) {
                System.out.println("The disc with title " + disc.getTitle() + " has been removed.");
                for (int j = i; j < qtyOrdered - 1; ++j)
                    itemsOrdered[j] = itemsOrdered[j + 1];
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                return;
            }
        }
        System.out.println("The disc with title " + disc.getTitle() + " is not found in cart.");
    }

    public float totalCost () {
        float ans = 0;
        for (int i = 0; i < qtyOrdered; ++i) {
            ans += itemsOrdered[i].getCost();
        }
        return ans;
    }
}