package practice11.exam02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    private static List<Goods> goodsList = Arrays.asList(
            new Goods("메타몽 쿠션", "분홍", false),
            new Goods("메타몽 노트북 파우치", "보라", true),
            new Goods("메타몽 인형", "분홍", false),
            new Goods("메타몽 가방", "회색", true),
            new Goods("메타몽 키링", "파랑", false)
    );

    public static void printSelectedGoods(String user, Predicate<Goods> filter) {
        System.out.printf("[%s의 선택]\n", user);
        for (Goods item : goodsList) {
            if (filter.test(item)) {
                System.out.println("- " + item.getName());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printSelectedGoods("이슬이", goods -> goods.getColor().equalsIgnoreCase("분홍"));
        printSelectedGoods("지우", Goods::isUseful);
    }
}
