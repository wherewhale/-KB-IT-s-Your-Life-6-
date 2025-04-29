package practice09.quiz;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QuizIterator implements Iterator<QuizNode> {
    private QuizNode quizNode;

    public QuizIterator(QuizNode quizNode) {
        this.quizNode = quizNode;
    }

    @Override
    public boolean hasNext() {
        return quizNode != null;
    }

    @Override
    public QuizNode next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            QuizNode currNode = quizNode;
            quizNode = quizNode.next;
            return currNode;
        }
    }
}
