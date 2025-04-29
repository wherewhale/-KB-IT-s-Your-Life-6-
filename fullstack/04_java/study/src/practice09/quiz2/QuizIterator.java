package practice09.quiz2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QuizIterator implements Iterator<QuizNode> {
    QuizNode quizNode;

    QuizIterator(QuizNode quizNode) {
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
