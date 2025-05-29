package practice14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class CardTemplate implements Product {
    @Getter
    String title;
    String frameChar;

    public void CardTemplate(String title, String frameChar) {
        this.title = title;
        this.frameChar = frameChar;
    }

    @Override
    public void use(String s) {
        System.out.println("[" + title + "]");
        System.out.println(frameChar.repeat(42));
        System.out.println(s);
        System.out.println(frameChar.repeat(42));
        System.out.println();
    }


    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }

}
