package practice09.quiz2;

import java.util.Iterator;

public class QuizLinkedList implements Iterable<QuizNode> {
    QuizNode head; // 첫 번째 문제를 가리킴

    void addLast(String title, String answer) {
        QuizNode endNode = new QuizNode(title, answer);

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

    int size() {
        int count = 0;
        QuizNode curNode = head;

        while (curNode != null) {
            count++;
            curNode = curNode.next;
        }
        return count;
    }

    @Override
    public Iterator<QuizNode> iterator() {
        return new QuizIterator(head);
    }
}
