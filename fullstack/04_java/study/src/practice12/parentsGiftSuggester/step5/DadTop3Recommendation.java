package practice12.parentsGiftSuggester.step5;

import practice12.parentsGiftSuggester.data.GiftRepository;
import practice12.parentsGiftSuggester.model.GiftItem;

import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DadTop3Recommendation {
    public static void run() {
        List<GiftItem> giftItemList = GiftRepository.getGifts();
        NumberFormat nf = NumberFormat.getInstance();
        List<GiftItem> filteredItems = giftItemList.stream()
                .filter(GiftItem::isForDad)
                .sorted((a, b) -> Integer.compare(b.getPreferenceScore(), a.getPreferenceScore()))
                .limit(3)
                .toList();

        if (filteredItems.isEmpty()) {
            System.out.println("😭 아빠를 위한 추천 선물이 없습니다.");
            return;
        }

        int maxPrice = filteredItems.stream().mapToInt(GiftItem::getPrice).max().orElse(0);
        int minPrice = filteredItems.stream().mapToInt(GiftItem::getPrice).min().orElse(0);

        AtomicInteger rank = new AtomicInteger(1);


        filteredItems.stream()
                //[손편지] - 기타 / ₩0원 / 선호도: 95점 (★★★★☆) 💸
                .forEach(
                        gift -> {
                            int score = gift.getPreferenceScore();
                            String stars = "★".repeat(score / 20) + "☆".repeat(5 - score / 20);
                            String badge = gift.getPrice() == maxPrice ? " 💎" :
                                    gift.getPrice() == minPrice ? " 💸" : "";

                            System.out.printf("%d. [%s] - %s / ₩%s원 / 선호도: %d점 (%s)%s\n",
                                    rank.getAndIncrement(),
                                    gift.getName(),
                                    gift.getCategory(),
                                    nf.format(gift.getPrice()),
                                    score,
                                    stars,
                                    badge
                            );
                        }
                );

        double average = filteredItems.stream().mapToInt(GiftItem::getPreferenceScore).average().getAsDouble();
        String price = nf.format((int) filteredItems.stream().mapToInt(GiftItem::getPrice).average().getAsDouble());

        System.out.println();
        System.out.println("\uD83D\uDCCA 평균 선호도: " + average + "점");
        System.out.println("\uD83D\uDCCA 평균 가격: ₩" + price + "원");
    }


}

