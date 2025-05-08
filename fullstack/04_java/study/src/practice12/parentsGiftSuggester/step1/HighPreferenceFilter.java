package practice12.parentsGiftSuggester.step1;

import practice12.parentsGiftSuggester.data.GiftRepository;

public class HighPreferenceFilter {
    public static void run() {
        System.out.println("\uD83C\uDF81 부모님이 진짜 좋아하시는 선물 리스트");
        GiftRepository.getGifts().stream()
                .filter(giftItem -> giftItem.getPreferenceScore() >= 70)
                .forEach(giftItem -> System.out.println(giftItem.getName()));
    }

}
