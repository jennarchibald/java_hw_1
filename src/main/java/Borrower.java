import java.util.ArrayList;

public class Borrower {

    private String name;
    private ArrayList<Book> collection;

    public Borrower(String name){
        this.name = name;
        this.collection = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public int booksInCollection() {
        return collection.size();
    }

    public void addBook(Book book) {
        collection.add(book);
    }

    public void borrowBookFromLibrary(Book book, Library library) {
        Book borrowedBook = library.lendBook(book);
        if (borrowedBook == null){
            return;
        }
        addBook(borrowedBook);
    }
}
