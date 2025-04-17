package ch05.sec07.exam03;

public class Korean {
    //필드 선언
    String nation = "대한민국";
    String name;
    String ssn;

    //command + n 을 쓰면 생성자를 편하게 쓸 수 있다.
    public Korean(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }
}

