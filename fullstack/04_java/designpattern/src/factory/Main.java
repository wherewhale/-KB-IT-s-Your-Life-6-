package factory;

import factory.framework.Factory;
import factory.framework.Product;
import factory.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("Youngjin Kim");
        Product card2 = factory.create("Heunmin Son");
        Product card3 = factory.create("Kane");
        System.out.println();

        //표준 사용법
        card1.use();
        card2.use();
        card3.use();
        //위와 같이 사용하게 되면 ID카드가 사용되었는지에 대해서는 직관적으로 알 수 없다.


    }
}
