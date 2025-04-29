package iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the world in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
// 명시적으로 Iterator를 사용하는 방법
        Iterator<Book> it = bookShelf.iterator();
        while(it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }
        //한 번 it로 끝까지 순회를 했다면 다시 순회가 불가능하다. (끝 위치에 있기 때문)
        //따라서, 다시 돌고 싶다면 iterator를 새로 얻어서 사용해야 한다.
        System.out.println();

        // 확장 for문을 사용하는 방법
        for(Book book: bookShelf) {
            System.out.println(book.getName());
        }
        System.out.println();
    }
}
