package practice01;

public class MainStep4 {
    public static void main(String[] args) {
        Band dreamstage = new Band("DreamStage");
        Band sweetz = new Band("스윗즈");
        Member zero = new Member("제로비트", "ENFP", "Vocal", 90);
        Member mint = new Member("민트초코", "ISTJ", "Guitar", 90);
        Member ai = new Member("아이시스", "ISFP", "Keyboard", 90);
        Member dongle = new Member("동글몽", "INTP", "Drums", 70);

        dreamstage.add(zero);
        sweetz.add(mint);
        sweetz.add(ai);
        sweetz.add(dongle);
        dreamstage.add(sweetz);

        BandProxy bandProxy = new BandProxy(dreamstage);

        System.out.println("[🎶 공연 순서 출력]");
        bandProxy.printStructure("");
        System.out.println();
        System.out.println("[🎉 공연 시작]");
        bandProxy.perform();
    }
}
