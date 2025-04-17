package ch06.sec07.exam02;

public class Korean {
    //필드 선언
    String nation = "대한민국";
    String name;
    String ssn;

    //생성자 선언 (접근 제어자 키워드가 없으므로 default)
    Korean(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }
}
