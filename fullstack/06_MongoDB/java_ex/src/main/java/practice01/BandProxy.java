package practice01;

public class BandProxy extends BandComponent{
    private Band band;

    public BandProxy(Band targetBand) {
        band = targetBand;
    }


    @Override
    public String getName() {
        return band.getName();
    }

    @Override
    public void perform() {
        System.out.println("🎭 공연 점검");
        int tiredPersonCount = 0;

        for(Member member : band.getMembers()) {
            if(member.getEnergyLevel() < 30) {
                tiredPersonCount++;
            }
        }

        if(tiredPersonCount >= 2) {
            System.out.println("❌ 컨디션 불량 멤버가 2명 이상입니다. 공연을 취소합니다.");
        } else if(tiredPersonCount == 1) {
            System.out.println("⚠\uFE0F 일부 멤버의 컨디션이 좋지 않지만 공연을 강행합니다...");
            band.perform();
        } else {
            System.out.println("✅ 멤버 컨디션 양호! 공연을 시작합니다!");
            band.perform();
        }

        System.out.println();


    }

    @Override
    public void printStructure(String prefix) {
        band.printStructure("");
    }
}
