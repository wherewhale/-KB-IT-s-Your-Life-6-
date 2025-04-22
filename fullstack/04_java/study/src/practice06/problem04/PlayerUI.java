package practice06.problem04;

public class PlayerUI {
    public interface ClickListener {
        void onClick();
    }

    private ClickListener listener;

    void setClickListener(ClickListener listener) {
        this.listener = listener;
    }

    void clickPlayButton() {
        if (listener != null) {
            listener.onClick();
        } else {
            System.out.println("❌ 리스너가 등록되지 않았습니다.");
        }
    }
}
