package practice06.problem08;

public class ModernPlayerAdapter implements Playable {
    private ModernPlayer modernPlayer;

    @Override
    public void play(String title) {
        if (!title.contains("bad")) {
            modernPlayer.begin(title);
        } else {
            System.out.printf("\uD83D\uDEAB 금지어가 포함된 곡은 재생할 수 없습니다: %s\n", title);
        }
    }

    ModernPlayerAdapter(ModernPlayer modernPlayer) {
        this.modernPlayer = modernPlayer;
    }
}
