package practice11.exam06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Set<String> emotionalWords = new HashSet<>(Arrays.asList(
                "미안", "사랑", "소중", "고마워", "행복", "고맙", "영원", "믿어"
        ));

        Function<String, Message> messageFunction = Message::new;

        Function<Message, Integer> scoreFunction = message -> {
            int score = 0;
            for (String emotionWord : emotionalWords) {
                if (message.content.contains(emotionWord)) {
                    score += 30;
                }
            }
            if (score > 100) {
                score = 100;
            }
            return score;
        };

        Consumer<Message> consumer = message -> {
            int score = scoreFunction.apply(message);
            System.out.println(message);
            System.out.println(" ✅ 감성 점수: " + score);
            System.out.println();
        };

        Predicate<Message> messagePredicate = message -> scoreFunction.apply(message) >= 60;

        String[] messages = {
                "지우|이슬이|오늘 말 심했지? 정말 미안해. 널 제일 소중하게 생각해.",
                "이슬이|지우|메타몽처럼 말랑말랑해질게. 나도 고마워 :)",
                "웅이|이슬이|사랑해. 영원히 같이 있고 싶어.",
                "지우|웅이|게임은 내가 이겼지롱~"
        };

        System.out.println("\uD83D\uDCEE 메타몽 편지함 - 진심 메시지만 공개됩니다 \uD83D\uDC8C");
        System.out.println();

        for (String message : messages) {
            Message newMessage = messageFunction.apply(message);
            if (messagePredicate.test(newMessage)) {
                consumer.accept(newMessage);
            }
        }

    }
}
