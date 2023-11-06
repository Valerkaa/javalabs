import java.util.ArrayList;
import java.util.List;

class Library {

    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().equals(title.toLowerCase())) {
                return book;
            }
        }
        return null;
    }

    public void removeBookByIsbn(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.remove(i);
                return;
            }
        }
    }

}

class Book {

    private String title;
    private String author;
    private String isbn;
    private int yearOfPublication;

    public Book(String title, String author, String isbn, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                '}';
    }
}

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        // Додаємо книги
        Book book1 = new Book("Java for junior", "Djoe Row", "1234567890", 2023);
        Book book2 = new Book("Python for junior", "Will Smeet", "2345678901", 2022);
        library.addBook(book1);
        library.addBook(book2);

        // Показуємо всі книги
        library.showBooks();

        // Шукаємо книгу за назвою
        String title = "Java for junior";
        Book foundBook = library.findBookByTitle(title);
    }
}