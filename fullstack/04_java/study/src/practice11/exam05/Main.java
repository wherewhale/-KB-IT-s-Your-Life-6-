package practice11.exam05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class Main {
    public static int totalPrice(ToIntFunction<Goods> function, List<Goods> goodsList) {
        int sum = 0;
        for (Goods item : goodsList) {
            sum += function.applyAsInt(item);
        }

        return sum;
    }

    public static void main(String[] args) {
        List<Goods> goodsList1 = new ArrayList<>(Arrays.asList(
                new Goods("메타몽 쿠션", 20000, 0.1),
                new Goods("메타몽 키링", 8000, 0.05),
                new Goods("메타몽 인형", 15000, 0.2)
        ));

        List<Goods> goodsList2 = new ArrayList<>(Arrays.asList(
                new Goods("메타몽 노트북 파우치", 30000, 0.2),
                new Goods("메타몽 가방", 40000, 0.2)
        ));

        System.out.println("[이슬이의 장바구니]");
        for (Goods item : goodsList1) {
            System.out.println("- " + item.getName() + ": " + (int) item.getDiscountedPrice() + "원");
        }

        int total1 = totalPrice(i -> (int) i.getDiscountedPrice(), goodsList1);
        System.out.println("총합: " + total1 + "원");

        System.out.println();

        System.out.println("[지우의 장바구니]");
        for (Goods item : goodsList2) {
            System.out.println("- " + item.getName() + ": " + (int) item.getDiscountedPrice() + "원");
        }
        int total2 = totalPrice(i -> (int) i.getDiscountedPrice(), goodsList2);
        System.out.println("총합: " + total2 + "원");
    }
}
