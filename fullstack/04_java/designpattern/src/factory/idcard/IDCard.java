package factory.idcard;

import factory.framework.Product;

//이 카드의 사용법은 use라는 메소드로 사용한다는 형식으로 Product(부모)에서 결정해둠
public class IDCard extends Product {
    private String owner;

    public IDCard(String owner) {
        System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() {
        return "[IDCard:" + owner + "]";
    }
}
