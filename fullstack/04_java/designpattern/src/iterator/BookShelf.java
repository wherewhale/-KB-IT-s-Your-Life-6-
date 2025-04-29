package iterator;

import java.util.Iterator;

// BookShelf는 Iterable<Book> 인터페이스를 구현한 객체여야 한다.
public class BookShelf implements Iterable<Book>{
    private Book[] books;
    private int last = 0;
    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }
    public Book getBookAt(int index) {
        return books[index];
    }
    public void appendBook(Book book) {
        books[last] = book;
        last++;
    }
    public int getLength() {
        return last;
    }
    @Override
    public Iterator<Book> iterator() {
        //실제 for 루프를 돌 때 사용하는 객체
        return new BookShelfIterator(this);
    }
}
