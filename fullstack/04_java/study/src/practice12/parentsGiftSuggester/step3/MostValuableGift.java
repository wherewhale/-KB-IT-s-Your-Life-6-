package practice12.parentsGiftSuggester.step3;

import practice12.parentsGiftSuggester.data.GiftRepository;
import practice12.parentsGiftSuggester.model.GiftItem;

import java.text.NumberFormat;
import java.util.Optional;

public class MostValuableGift {
    public static void run() {
        NumberFormat nf = NumberFormat.getInstance();
        boolean momMode = false;
        System.out.println("\uD83D\uDC8E 부모님께 드릴 수 있는 최고의 프리미엄 선물");
        //💝 [홍삼진액] - 건강식품 (₩120,000) / 선호도: 85점
        //🎁 [무릎안마기] - 전자기기 (₩150,000) / 선호도: 92점

        Optional<GiftItem> optionalGiftItem = GiftRepository.getGifts().stream()
                .filter(giftItem -> {
                    if (momMode) {
                        return giftItem.isForMom();
                    } else {
                        return giftItem.isForDad() && giftItem.getPreferenceScore() >= 120;
                    }
                }).max((a, b) -> Integer.compare(a.getPrice(), b.getPrice()));

        optionalGiftItem.ifPresent(giftItem -> {
            if (momMode) {
                System.out.print("\uD83D\uDC9D");
            } else {
                System.out.print("\uD83C\uDF81");
            }

            System.out.printf("[%s] - %s (₩%s) / 선호도: %d점\n", giftItem.getName(), giftItem.getCategory(), nf.format(giftItem.getPrice()), giftItem.getPreferenceScore());
        });

        if (optionalGiftItem.isEmpty()) {
            System.out.println("\uD83D\uDE22 조건에 맞는 고가의 선물을 찾지 못했어요.");
        }

    }
}
