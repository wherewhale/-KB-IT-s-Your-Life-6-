package ch15.sec02.exam01;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Board> array = new ArrayList<>();

        Board board1 = new Board("제목1", "내용1", "글쓴이1");
        Board board2 = new Board("제목2", "내용2", "글쓴이2");
        Board board3 = new Board("제목3", "내용3", "글쓴이3");
        Board board4 = new Board("제목4", "내용4", "글쓴이4");
        Board board5 = new Board("제목5", "내용5", "글쓴이5");

        array.add(board1);
        array.add(board2);
        array.add(board3);
        array.add(board4);
        array.add(board5);

        System.out.println("ArrayList에 저장된 수 : " + array.size());
        System.out.println("ArrayList에서 세 번째 데이터) ");
        System.out.println("제목 : " + array.get(2).getSubject());
        System.out.println("내용 : " + array.get(2).getContent());
        System.out.println("글쓴이 : " + array.get(2).getWriter());

        for (int i = 0; i < array.size(); i++) {
            System.out.println("제목 : " + array.get(i).getSubject());
            System.out.println("내용 : " + array.get(i).getContent());
            System.out.println("글쓴이 : " + array.get(i).getWriter());
        }
        array.remove(2);
        array.remove(2);

        for (Board board : array) {
            System.out.println("제목 : " + board.getSubject());
            System.out.println("내용 : " + board.getContent());
            System.out.println("글쓴이 : " + board.getWriter());
        }
    }
}
