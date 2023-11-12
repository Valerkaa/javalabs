import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String Name;
    private String UniqueID;
    private List<Item> BorrowedItems;
    private static int nextID = 1;

    public Patron(String name) {
        this.Name = name;
        this.UniqueID = "P" + nextID++;
        this.BorrowedItems = new ArrayList<>();
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getUniqueID() {
        return this.UniqueID;
    }

    public List<Item> getBorrowedItems() {
        return this.BorrowedItems;
    }

    public boolean borrowItem(Item item) {
        if (item != null && !BorrowedItems.contains(item)) {
            return BorrowedItems.add(item);
        }
        return false;
    }

    public boolean returnItem(Item item) {
        if (item != null) {
            return BorrowedItems.remove(item);
        }
        return false;
    }
}
