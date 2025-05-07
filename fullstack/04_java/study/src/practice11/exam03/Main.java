package practice11.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    private static List<Goods> giftPool = new ArrayList<>(Arrays.asList(
            new Goods("메타몽 쿠션", "분홍", false),
            new Goods("메타몽 키링", "파랑", false),
            new Goods("메타몽 텀블러", "보라", true),
            new Goods("메타몽 노트북 파우치", "회색", true),
            new Goods("메타몽 인형", "분홍", false),
            new Goods("메타몽 가방", "회색", true)
    ));

    public static Supplier<List<Goods>> pickGifts(List<Goods> pool) {
        List<Goods> pickedList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int randomIndex = random.nextInt(pool.size());
            pickedList.add(pool.get(randomIndex));
            pool.remove(randomIndex);
        }

        return () -> pickedList;
    }

    public static void printResult(String user, List<Goods> picks, Predicate<Goods> condition, String successMsg, String failMsg) {
        System.out.printf("[%s의 뽑기 결과]\n", user);
        for (Goods item : picks) {
            System.out.printf("- %s (%s)\n", item.getName(), item.getColor());
        }
        System.out.println();

        if (picks.stream().anyMatch(condition)) {
            System.out.println(successMsg);
        } else {
            System.out.println(failMsg);
        }
    }

    public static void main(String[] args) {
        Supplier<List<Goods>> pickedList1 = pickGifts(giftPool);
        Supplier<List<Goods>> pickedList2 = pickGifts(giftPool);

        printResult("이슬이", pickedList1.get(), goods -> goods.getColor().equalsIgnoreCase("분홍"), "→ 성공! 분홍색 굿즈를 얻었어요! \uD83C\uDF89", "→ 실패! 분홍색 굿즈가 없어요 \uD83D\uDE22");
        printResult("지우", pickedList2.get(), goods -> goods.isUseful(), "→ 성공! 유용한 굿즈를 얻었어요! \uD83C\uDF89", "→ 실패! 유용한 굿즈가 없어요 \uD83D\uDE22");
    }
}
