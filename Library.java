import java.util.ArrayList;
import java.util.List;

public class Library implements IManageable {
    private List<Item> ItemList;
    private List<Patron> PatronList;

    public Library() {
        ItemList = new ArrayList<>();
        PatronList = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (item != null) {
            ItemList.add(item);
        }
    }

    public void removeItem(Item item) {
        if (item != null) {
            ItemList.remove(item);
        }
    }

    public List<Item> listAvailable() {
        List<Item> availableItems = new ArrayList<>();
        for (Item item : ItemList) {
            if (!item.isBorrowed()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    public List<Item> listBorrowed() {
        List<Item> borrowedItems = new ArrayList<>();
        for (Patron patron : PatronList) {
            borrowedItems.addAll(patron.getBorrowedItems());
        }
        return borrowedItems;
    }

    public boolean registerPatron(Patron patron) {
        if (patron != null) {
            return PatronList.add(patron);
        }
        return false;
    }

    public boolean lendItem(Patron patron, Item item) {
        if (patron != null && item != null) {
            if (patron.getBorrowedItems().contains(item)) {
                return false; // Предмет уже взят в аренду патроном
            }
            item.borrowItem();
            return patron.getBorrowedItems().add(item);
        }
        return false;
    }

    public boolean returnItem(Patron patron, Item item) {
        if (patron != null && item != null) {
            if (patron.getBorrowedItems().contains(item)) {
                item.returnItem();
                patron.getBorrowedItems().remove(item);
                if (patron.getBorrowedItems().isEmpty()) {
                    PatronList.remove(patron);
                }
                return true;
            }
        }
        return false;
    }
}
