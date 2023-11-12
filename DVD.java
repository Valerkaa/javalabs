public class DVD extends Item {
    private String uniqueID;
    private boolean isBorrowed;
    private int duration;
    private static int nextID = 1;

    public DVD(String title, int duration) {
        super(title, "D" + nextID++);
        this.isBorrowed = false;
        this.duration = duration;
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
