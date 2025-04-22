package practice06.problem01;

public class MusicApp {
    String title, artist, genre;

    MusicApp(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    class MusicPlayer {
        void play() {
            String effect = getEffect(MusicApp.this.genre);
            System.out.printf("[%s][%s] - [%s] 을(를) 재생합니다.[%s]\n", effect, MusicApp.this.title, MusicApp.this.artist, effect);
        }

        String getEffect(String genre) {
            String effect;
            if (genre.equals("HIPHOP")) {
                effect = "💥";
            } else if (genre.equals("BALLAD")) {
                effect = "🎵";
            } else {
                effect = "🎧";
            }
            return effect;
        }
    }
}
