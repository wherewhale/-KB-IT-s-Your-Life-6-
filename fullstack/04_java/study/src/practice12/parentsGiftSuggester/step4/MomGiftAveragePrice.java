package practice12.parentsGiftSuggester.step4;

import practice12.parentsGiftSuggester.data.GiftRepository;
import practice12.parentsGiftSuggester.model.GiftItem;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.OptionalDouble;

public class MomGiftAveragePrice {
    public static void run() {
        NumberFormat df = DecimalFormat.getInstance();
        List<GiftItem> giftItems = GiftRepository.getGifts().stream()
                .filter(giftItem -> giftItem.isForMom() && giftItem.getPreferenceScore() >= 70)
                .toList();

        OptionalDouble optional = giftItems.stream()
                .mapToInt(GiftItem::getPrice).average();

        optional.ifPresentOrElse(
                avg -> {
                    System.out.println("\uD83D\uDC69 엄마 전용 선물들의 평균 가격 리포트");

                    System.out.println("\uD83D\uDCE6 포함된 선물:");
                    giftItems.stream()
                            .map(giftItem -> "- " + giftItem.getName())
                            .forEach(System.out::println);

                    System.out.print("\uD83D\uDCCA 평균 가격: ");
                    System.out.println(df.format(optional.getAsDouble()) + "원");
                },
                () -> {
                    System.out.println("\uD83D\uDE2D 조건에 맞는 엄마 전용 선물이 아직 없습니다.");
                }
        );


    }
}
