import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    Library library;
    Book book1;
    Book book2;
    Book book3;
    Book book4;

    @Before
    public void before(){
        library = new Library();
        book1 = new Book("Harry Potter", "JK Rowling", "Fantasy");
        book2 = new Book("Jekyll and Hyde", "RL Stevenson", "Horror");
        book3 = new Book("Frankenstein", "M Shelley", "Horror");
        book4 = new Book("The BFG", "R Dahl", "Childrens");
    }

    @Test
    public void canCountBooks(){
        assertEquals(0, library.bookCount());
    }

    @Test
    public void canAddBook(){
        library.addBook(book1);
        assertEquals(1, library.bookCount());
    }

    @Test
    public void hasCapacity(){
        assertEquals(3, library.getCapacity());
    }

    @Test
    public void doesntAddBookIfFull(){
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        assertEquals(3, library.bookCount());
    }

    @Test
    public void canLendBook(){
        library.addBook(book1);
        assertEquals(book1, library.lendBook(book1));
        assertEquals(0, library.bookCount());
    }

    @Test
    public void deosntLendBookIfNotOnShelves(){
        library.addBook(book1);
        assertEquals(null, library.lendBook(book3));
        assertEquals(1, library.bookCount());
    }

    @Test
    public void keepsCountOfGenres(){
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        assertEquals(1, library.getGenreCount("Fantasy"));
        assertEquals(2, library.getGenreCount("Horror"));
    }

}
