package builder2;

public class Main {
    public static void main(String[] args) {
        User user = User.builder() //Builder
                .name("홍길동") //Builder
                .email("hong@scoula.org")
                .password("123456")
                .phone("010-1111-22222")
                .address("서울시")
                .sex(true)
                .age(16)
                .build(); //User 호출
        System.out.println(user);
    }
    //호출하는 순서, 일부 값의 누락이 있어도 상관이 없음
    //내부 default 값이 있기 때문에
}
