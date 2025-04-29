package iterator;

public class Book {
    private String name; // record로 구성하면 편리하게 관리 가능 recordBook(string name) {}

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
