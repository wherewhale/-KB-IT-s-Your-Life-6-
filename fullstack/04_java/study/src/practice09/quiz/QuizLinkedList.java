package practice09.quiz;

import java.util.Iterator;

public class QuizLinkedList implements Iterable<QuizNode> {
    QuizNode head; // 첫 번째 문제를 가리킴

    void addLast(String title, String content) {
        QuizNode endNode = new QuizNode();
        endNode.title = title;
        endNode.content = content;

        if (head == null) {
            head = endNode;
        } else {
            QuizNode curNode = head;
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = endNode;
        }
    }

    void addFirst(String title, String content) {
        QuizNode newNode = new QuizNode();
        newNode.title = title;
        newNode.content = content;
        newNode.next = head;
        head = newNode;
    }

    void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    void addAt(int index, String title, String content) {
        if (index == 0) {  // 인덱스 0일 때는 addFirst
            addFirst(title, content);
            return;
        }

        int curIndex = 0;
        QuizNode curNode = head;

        while (curNode != null && curIndex < index - 1) {
            curNode = curNode.next;
            curIndex++;
        }

        if (curNode == null) {
            System.out.println("인덱스 범위 초과");
            return;
        }

        QuizNode newNode = new QuizNode();
        newNode.title = title;
        newNode.content = content;
        newNode.next = curNode.next;
        curNode.next = newNode;
    }

    int size() {
        int count = 0;
        QuizNode curNode = head;

        while (curNode != null) {
            count++;
            curNode = curNode.next;
        }
        return count;
    }

    void printAll() {
        QuizNode curNode = head;
        System.out.println("=== 현재 도전할 문제 리스트 ===");

        while (curNode != null) {
            System.out.println("문제 제목 : " + curNode.title);
            System.out.println("문제 내용 : " + curNode.content);
            System.out.println();
            curNode = curNode.next;
        }
    }

    @Override
    public Iterator<QuizNode> iterator() {
        return new QuizIterator(head);
    }
}
