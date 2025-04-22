package practice06.problem06;

public class MusicApp {
    private String user = "yura";

    public static class PlayerUI {
        public void show(MusicApp app) {
            System.out.println("🎧 현재 사용자: " + app.user); // ❌ 컴파일 에러 발생
        }
    }

    public static void main(String[] args) {
        MusicApp app = new MusicApp();               // 외부 클래스 인스턴스
        MusicApp.PlayerUI ui = new MusicApp.PlayerUI(); // 중첩 static 클래스 인스턴스
        ui.show(app);
    }
}
