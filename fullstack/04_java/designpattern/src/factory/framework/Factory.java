package factory.framework;

public abstract class Factory {
    //template
    public final Product create(String owner) {
        //카드의 소유자를 정의하며 등록
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    //어떻게 생성하고, 만들지에 대해서는 자식에게 미룸
    protected abstract Product createProduct(String owner); //추상
    protected abstract void registerProduct(Product product); //추상
}
