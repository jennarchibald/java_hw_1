import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    Borrower borrower;
    Book book1;
    Book book2;
    Library library;


    @Before
    public void before(){
        library = new Library();
        borrower = new Borrower("Jenn");
        book1 = new Book("Harry Potter", "JK Rowling", "Fantasy");
        book2 = new Book("Jekyll and Hyde", "RL Stevenson", "Horror");
        library.addBook(book2);
    }

    @Test
    public void hasName(){
        assertEquals("Jenn", borrower.getName());
    }

    @Test
    public void hasEmptyCollection(){
        assertEquals(0, borrower.booksInCollection());
    }

    @Test
    public void canAddBookToCollection(){
        borrower.addBook(book1);
        assertEquals(1, borrower.booksInCollection());
    }

    @Test
    public void canBorrowBookFromLibrary(){
        borrower.borrowBookFromLibrary(book2, library);
        assertEquals(0, library.bookCount());
        assertEquals(1, borrower.booksInCollection());
    }

    @Test
    public void cannotBorrowBookNotInLibrary(){
        borrower.borrowBookFromLibrary(book1, library);
        assertEquals(1, library.bookCount());
        assertEquals(0, borrower.booksInCollection());
    }
}
