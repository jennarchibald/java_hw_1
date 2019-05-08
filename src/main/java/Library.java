import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> shelves;
    private int capacity;
    private HashMap<String, Integer> genreCount;

    public Library(){
        this.shelves = new ArrayList<>();
        this.capacity = 3;
        this.genreCount = new HashMap();
    }

    public int bookCount() {
        return shelves.size();
    }

    public void addBook(Book book) {
        if (spaceOnShelves()){
            shelves.add(book);
            addToGenreCount(book.getGenre());
        }
    }

    private void addToGenreCount(String genre) {
        int count = genreCount.containsKey(genre) ? genreCount.get(genre) : 0;
        genreCount.put(genre, count + 1);
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean spaceOnShelves(){
        return bookCount() < capacity;
    }

    public Book lendBook(Book book) {
        if (shelves.remove(book)){
            return book;
        }
        return null;
    }

    public int getGenreCount(String genre) {
        return genreCount.get(genre);
    }
}
