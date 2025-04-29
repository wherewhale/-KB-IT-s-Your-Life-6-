package practice09.quiz2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuizMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuizLinkedList quizLinkedList = new QuizLinkedList();
        ArrayList<QuizNode> quizNodeArrayList = new ArrayList<>();
        int index = 0;
        int quizSize = 0;
        List<QuizNode> correctList = new ArrayList<>();
        List<QuizNode> incorrectList = new ArrayList<>();

        String data = """
                초인종이 없을 때를 두 글자로 줄이면? - 노벨
                보라돌이 나나 뽀가 자기들끼리 식사할 때 두비가 하는 말은? - 뚜비두밥
                등산을 좋아하는 왕은? - 하이킹
                고등학생이 싫어하는 나무는? - 야자나무
                포도가 자기소개할 때 하는 말은? - 포도당
                신데렐라가 잠을 못 자면? - 모짜렐라
                <옷장 안에 불이 났다>를 다섯 글자로 하면? - 장안의 화재
                호랑이가 차를 타고 가다가 친구를 만나서 하는 말은? - 타이거
                몸이 아파도 반드시 가야 하는 대학교는? - 가야대
                인사하면서 웃으면? - 하이킥
                자동차를 톡하고 치면? - 카톡
                <이것이 코다>를 세 글자로 줄이면? - 디스코
                소녀가 강으로 여행을 가면? - 걸리버 여행
                소고기가 없는 나라는? - 소고기무국
                드라큘라가 가장 싫어하는 사람은? - 찔러도 피 안 나는 사람
                때돈을 버는 곳은? - 목욕탕
                자동차 키 색은? - 카키색
                해와 달 중, 해만 취재하는 사람은? - 해리포터
                입이 S자로 되어있으면? - EBS
                신문이 일하러 가면? - 일간신문
                """;

        String[] quizArray = data.split("\n");

        for (String quiz : quizArray) {
            String[] tmp = quiz.split(" - ");

            quizLinkedList.addLast(tmp[0].trim(), tmp[1].trim());
        }

        for (QuizNode node : quizLinkedList) {
            quizNodeArrayList.add(node);
        }

        Collections.shuffle(quizNodeArrayList);

        quizSize = quizNodeArrayList.size();

        for (QuizNode node : quizNodeArrayList) {
            index++;
            System.out.printf("[%d/%d] 문제: %s\n", index, quizSize, node.title);
            System.out.print("답변 입력 : ");
            String answer = sc.nextLine().trim();

            if (node.answer.equalsIgnoreCase(answer)) {
                correctList.add(node);
                System.out.println("정답입니다!!\n");
            } else {
                incorrectList.add(node);
                System.out.printf("오답입니다! (정답: %s)\n\n", node.answer);
            }
        }

        System.out.println("=== 맞춘 문제 목록 ===");
        for (QuizNode node : correctList) {
            System.out.println("문제: " + node.title);
            System.out.println("정답: " + node.answer);
            System.out.println();
        }

        System.out.println();
        System.out.println("=== 틀린 문제 목록 ===");
        for (QuizNode node : incorrectList) {
            System.out.println("문제: " + node.title);
            System.out.println("정답: " + node.answer);
            System.out.println();
        }

        System.out.println();
        System.out.println("=== 최종 결과 ===");
        System.out.printf("총 %d문제 중 %d문제 정답!", quizSize, correctList.size());
        System.out.printf("정답률: %d", (int) (((double) correctList.size() / quizSize) * 100));
        System.out.print("%");
    }


}
