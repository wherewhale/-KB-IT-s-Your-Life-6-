package practice06.problem02;

public class PlayerSettings {
    //필드명 타입 기본값 설명
    //shuffle boolean false 셔플 여부
    //repeat boolean true 반복 여부
    //volumeLevel int 5 볼륨 (0~10)

    static boolean shuffle = false;
    static boolean repeat = true;
    static int volumeLevel = 5;

    public static class Mode {
        public static void printSettings() {
            System.out.println("\n\n\uD83C\uDF9B 현재 재생 설정 상태");
            System.out.println("- Shuffle: " + (PlayerSettings.shuffle ? "ON" : "OFF"));
            System.out.println("- Repeat: " + (PlayerSettings.repeat ? "ON" : "OFF"));
            System.out.println("- Volume: " + PlayerSettings.volumeLevel);
        }

        public static void setShuffle(boolean value) {
            PlayerSettings.shuffle = !PlayerSettings.shuffle;
            System.out.println("Shuffle 모드가" + (PlayerSettings.shuffle ? " ON 으로" : " OFF 로") + " 설정되었습니다.");
        }

        public static void setRepeat(boolean value) {
            PlayerSettings.repeat = !PlayerSettings.repeat;
            System.out.println("Repeat 모드가" + (PlayerSettings.repeat ? " ON 으로" : " OFF 로") + " 설정되었습니다.");
        }

        public static void setVolumeLevel(int level) {
            if (level < 0 || level > 10) {
                System.out.println("볼륨은 0~10 사이로 설정해야 합니다");
            } else {
                PlayerSettings.volumeLevel = level;
                System.out.printf("볼륨이 %d로 설정되었습니다.\n", level);
            }
        }
    }
}
