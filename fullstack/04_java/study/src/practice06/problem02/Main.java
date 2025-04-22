package practice06.problem02;

public class Main {
    public static void main(String[] args) {
        PlayerSettings.Mode.printSettings();
        PlayerSettings.Mode.setShuffle(true);
        PlayerSettings.Mode.setRepeat(false);
        PlayerSettings.Mode.setVolumeLevel(11);
        PlayerSettings.Mode.setVolumeLevel(7);
        PlayerSettings.Mode.printSettings();
    }
}
