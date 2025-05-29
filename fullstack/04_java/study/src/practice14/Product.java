package practice14;

public interface Product extends Cloneable {
    void use(String s);

    Product createCopy();
}
