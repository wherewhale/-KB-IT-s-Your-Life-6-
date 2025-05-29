package practice01;

public class Member extends BandComponent {
    private String name;
    private String mbti;
    private String position;
    private int energyLevel;

    public Member(String name, String mbti, String position, int energyLevel) {
        this.name = name;
        this.mbti = mbti;
        this.position = position;
        this.energyLevel = energyLevel;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void perform() {
        String emoji;
        String comment;
        if(mbti.equals("ENFP")) {
            emoji = "\uD83D\uDD25"; 
            comment = "여러분 안녕!! 불태워볼까요?";
        } else if (mbti.equals("ISTJ")) {
            emoji = "\uD83E\uDDCA";
            comment = "공연 시작합니다.";
        } else if (mbti.equals("ISFP")) {
            emoji = "\uD83C\uDF19";
            comment = "조용히 시작해볼게요.";
        } else if (mbti.equals("INTP")) {
            emoji = "\uD83E\uDDE0";
            comment = "이 곡은 구조적으로 매우 완벽합니다.";
        } else if (mbti.equals("ESFJ")) {
            emoji = "\uD83D\uDC95";
            comment = "다들 잘 지냈죠? 오늘도 힘내요!";
        } else {
            emoji = "\uD83C\uDFB6";
            comment = "준비됐어요!";
        }
        
        if(energyLevel < 30) {
            comment = "너무 지쳐서 공연을 못 하겠어요...";
        }

        System.out.printf("%s [%s] %s: %s\n", emoji, mbti, name, comment);
    }

    public void printStructure(String startwith) {
        System.out.printf("|-%s \uD83C\uDFB8 %s - %s (%s)\n",startwith, position, name, mbti);
    }
}
