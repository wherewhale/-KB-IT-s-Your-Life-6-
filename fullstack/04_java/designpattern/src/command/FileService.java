package command;

public class FileService {
    String filename;

    //Command 인터페이스에 준하는 모양새를 가짐
    //인스턴스 메소드
    void open() {
        filename = "test.txt";
        System.out.println(filename + "열었습니다.");
    }

    //Command 인터페이스에 준하는 모양새를 가짐
    //인스턴스 메소드
    void print() {
        System.out.println(filename + "프린트 합니다.");
    }
}
