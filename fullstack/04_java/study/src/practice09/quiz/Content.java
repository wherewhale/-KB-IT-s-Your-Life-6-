package practice09.quiz;

public class Content {
    private String question;

    Content(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public boolean equals(Object obj) {
        Quiz quiz = (Quiz) obj;
        return question.equals(quiz.getQuestion());
    }
}
