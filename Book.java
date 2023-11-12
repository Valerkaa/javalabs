public class Book extends Item {
    private String title;
    private String uniqueID;
    private boolean isBorrowed;
    private String author;
    private static int nextID = 1;

    public Book(String title, String author) {
        super(title, "B" + nextID++);
        this.title = title;
        this.isBorrowed = false;
        this.author = author;
    }

    @Override
    public void borrowItem() {
        isBorrowed = true;
    }

    @Override
    public void returnItem() {
        isBorrowed = false;
    }
}
