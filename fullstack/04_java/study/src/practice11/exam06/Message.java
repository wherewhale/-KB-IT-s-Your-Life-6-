package practice11.exam06;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    String sender;
    String receiver;
    String content;

    public Message(String s) {
        String[] arr = s.split("\\|");
        sender = arr[0];
        receiver = arr[1];
        content = arr[2];
    }

    @Override
    public String toString() {
        return "[ " + sender + " → " + receiver + " ]\n" + "\"" + content + "\"";
    }
}
