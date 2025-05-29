package practice16;

import java.util.Scanner;

public class TestFilter {
    public static void main(String[] args) {
        FilterStrategy f1 = new SmoothSkinFilter();
        //System.out.println(f1.apply("My Face")); // "my face✨"

        FilterStrategy f2 = new CuteEyesFilter();
        //System.out.println(f2.apply("Beautiful")); // "B👁👁t👁f👁l"

        FilterStrategy f3 = new KawaiiFilter();
        //System.out.println(f3.apply("Lovely")); // "ylevoL🌸"


        Scanner sc = new Scanner(System.in);
        String filter = "";
        String picture = "";
        String result = "";


        System.out.println("📸 AI 필터 엔진에 오신 걸 환영합니다!");
        System.out.println("✨ 사용할 필터를 선택해주세요 (smooth, cute, kawaii, exit)");

        while (true) {
            System.out.print("\n\n>> 적용할 필터 입력: ");
            filter = sc.nextLine().toLowerCase();

            if (filter.equals("exit")) {
                break;
            } else if (filter.equals("smooth") || filter.equals("cute") || filter.equals("kawaii")) {
                System.out.print(">> 사진 입력: ");
                picture = sc.nextLine();

                switch (filter.toLowerCase()) {
                    case "smooth":
                        result = f1.apply(picture);
                        System.out.printf("[사용 필터: %s] => %s", filter, result);
                        break;
                    case "cute":
                        result = f2.apply(picture);
                        System.out.printf("[사용 필터: %s] => %s", filter, result);
                        break;
                    case "kawaii":
                        result = f3.apply(picture);
                        System.out.printf("[사용 필터: %s] => %s", filter, result);
                        break;
                }
            } else {
                System.out.println("⚠\uFE0F 존재하지 않는 필터입니다. 다시 입력해주세요.");
            }


        }

        System.out.println("\uD83D\uDCF8 필터 부스를 종료합니다. 안녕히 가세요!");

    }

}
