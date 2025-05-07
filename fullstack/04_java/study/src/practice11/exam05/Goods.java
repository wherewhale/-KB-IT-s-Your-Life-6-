package practice11.exam05;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Goods {
    private String name;
    private int price;         // 정가
    private double discount;   // 할인율 (예: 0.2 = 20%)

    double getDiscountedPrice() {
        return price * (1 - discount);
    }
}
