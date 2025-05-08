package practice12.parentsGiftSuggester.step6;

import practice12.parentsGiftSuggester.data.GiftRepository;
import practice12.parentsGiftSuggester.model.GiftItem;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CategorySummaryReport {
    public static void run() {
        NumberFormat nf = NumberFormat.getInstance();
        Map<String, List<GiftItem>> map = GiftRepository.getGifts().stream()
                .collect(
                        Collectors.groupingBy(giftItem -> giftItem.getCategory()));

        System.out.println("""
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                \uD83D\uDCE6 카테고리별 선물 요약 리포트
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━""");

        map.forEach((s, gift) -> {
            List<Integer> prices = gift.stream()
                    .map(GiftItem::getPrice)
                    .collect(Collectors.toList());

            int count = prices.size();
            double average = prices.stream().mapToInt(Integer::intValue).average().orElse(0);
            int max = prices.stream().mapToInt(Integer::intValue).max().orElse(0);
            int min = prices.stream().mapToInt(Integer::intValue).min().orElse(0);

            System.out.println("[" + s + "]");
            System.out.printf(" - 총 개수     : %d개\n", count);
            System.out.printf(" - 평균 가격   : ₩%s원\n - 최고가      : ₩%s원\n - 최저가      : ₩%s원\n\n",
                    nf.format((int) average), nf.format(max), nf.format(min));
        });

        System.out.println("""
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                리포트 생성 완료 ✅
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                """);
    }
}
