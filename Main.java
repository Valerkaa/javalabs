
public class Main
{
    public static void main(String[] args)
    {
        Book Book1 = new Book("Book1","Author1");
        DVD DVD1 = new DVD("DVD1",120);

        Library Library1 = new Library();

        Library1.addItem(Book1);
        Library1.addItem(DVD1);

        int LibrarySize = Library1.listAvailable().size();
        for (int i = 0; i < LibrarySize; i++) {
            System.out.println(Library1.listAvailable().get(i).getTitle());
        }

        Patron Human = new Patron("Name");
        Library1.lendItem(Human, Book1);
        System.out.println(Human.getBorrowedItems().get(0).getTitle());
    }
}

