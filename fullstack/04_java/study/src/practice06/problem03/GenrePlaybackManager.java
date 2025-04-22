package practice06.problem03;

public class GenrePlaybackManager {
    public interface GenrePlayer {
        void play(String title, String artist);
    }

    // 현재 전략 저장용 필드
    private GenrePlayer player;

    // 전략 객체 주입
    public void setPlayer(GenrePlayer player) {
        this.player = player;
    }

    // 전략 실행 (재생 실행)
    public void play(String title, String artist) {
        if (player != null) {
            player.play(title, artist);
        } else {
            System.out.println("❌ 재생 전략이 설정되지 않았습니다.");
        }
    }

}
