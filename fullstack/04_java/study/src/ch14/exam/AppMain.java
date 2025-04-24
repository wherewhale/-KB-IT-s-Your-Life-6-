package ch14.exam;

public class AppMain {
    public static void main(String[] args) {
        Thread movieThread = new MovieThread();
        Thread musicRunnable = new Thread(new MusicRunnable());

        movieThread.start();
        musicRunnable.start();
    }
}
