package practice09.quiz2;

public class QuizNode {
    String title; //: 문제 제목
    String answer; //: 문제 정답
    QuizNode next; //: 다음 노드를 가리키는 포인터

    QuizNode(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }
}
