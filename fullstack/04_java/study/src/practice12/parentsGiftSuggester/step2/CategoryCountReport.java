package practice12.parentsGiftSuggester.step2;

import practice12.parentsGiftSuggester.data.GiftRepository;
import practice12.parentsGiftSuggester.model.GiftItem;

import java.util.stream.Collectors;

public class CategoryCountReport {
    public static void run() {
        System.out.println("\uD83D\uDCE6 카테고리별 선물 개수 요약");
        GiftRepository.getGifts().stream()
                .collect(Collectors.groupingBy(GiftItem::getCategory))
                .forEach((s, giftItems) -> System.out.println(s + ": " + giftItems.size() + "개"));
    }
}
