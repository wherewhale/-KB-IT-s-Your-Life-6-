package practice06.problem07;

public class MusicPlayer {
    public interface PlayResultListener {
        void onSuccess(String title);

        void onError(String title, int errorCode);
    }

    void play(String title, boolean isSuccess, PlayResultListener listener) {
        if (isSuccess) {
            listener.onSuccess(title);
        } else {
            listener.onError(title, 500);
        }
    }
}
