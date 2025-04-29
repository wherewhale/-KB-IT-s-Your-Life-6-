package practice09.quiz;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Quiz extends Content {
    private String question;
    private String answer;

    Quiz(String question, String answer) {
        super(question);
        this.setQuestion(question);
        this.setAnswer(answer);
    }

    public String getAnswer() {
        return answer;
    }
}
