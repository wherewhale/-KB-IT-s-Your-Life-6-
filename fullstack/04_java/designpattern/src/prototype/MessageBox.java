package prototype;

import prototype.framework.Product;

public class MessageBox implements Product {
    private char decochar;
    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int decolen = 1 + s.length() + 1;
        for(int i = 0; i < decolen; i++) {
            System.out.print(decochar);
        }
        System.out.println();
        System.out.println(decochar + s + decochar);
        for(int i = 0; i < decolen; i++) {
            System.out.print(decochar);
        }
        System.out.println();
    }

    @Override
    public Product createCopy() {
        Product p = null;

        try {
            p = (Product) clone(); //clone은 Object가 모두 가지는 메소드
            //Object 타입이 가지므로, 다운캐스팅을 해주어야 한다.
        } catch (CloneNotSupportedException e) {//Cloneable과 관련되어있다.
            e.printStackTrace();
        }
        return p;
    }
}
