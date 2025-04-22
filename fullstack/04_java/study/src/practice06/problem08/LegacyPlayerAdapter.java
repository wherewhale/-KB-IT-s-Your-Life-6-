package practice06.problem08;

public class LegacyPlayerAdapter implements Playable {
    private LegacyPlayer legacyPlayer;

    @Override
    public void play(String title) {
        if (!title.contains("bad")) {
            legacyPlayer.startPlay(title);
        } else {
            System.out.printf("\uD83D\uDEAB 금지어가 포함된 곡은 재생할 수 없습니다: %s\n", title);
        }
    }

    LegacyPlayerAdapter(LegacyPlayer legacyPlayer) {
        this.legacyPlayer = legacyPlayer;
    }
}
