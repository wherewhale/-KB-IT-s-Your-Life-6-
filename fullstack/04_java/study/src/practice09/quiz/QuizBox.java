package practice09.quiz;

import java.util.Arrays;

public class QuizBox<T extends Content> {
    private Object[] list;
    private int size;

    public QuizBox() {
        list = new Object[5];
        size = 0; //현재 크기 초기화
    }

    void add(T quiz) {
        if (size == list.length) {
            list = Arrays.copyOf(list, list.length * 2);
        }
        list[size] = quiz;
        size++;
    }

    void printAll() {
        for (int i = 0; i < size; i++) {
            Content c = (Content) list[i];
            System.out.println(i + 1 + ". " + c.getQuestion());

        }
    }

    boolean remove(Content content) {
        for (int i = 0; i < size; i++) {
            Content c = (Content) list[i];

            if (content.equals(c)) {
                for (int j = i; j < size - 1; j++) {
                    list[j] = list[j + 1];
                }
                list[--size] = null;
                return true;
            }
        }
        return false;
    }

    static <T extends Content> void removeFromBox(QuizBox<? super T> box, T quiz) {
        box.remove(quiz);
    }


}
