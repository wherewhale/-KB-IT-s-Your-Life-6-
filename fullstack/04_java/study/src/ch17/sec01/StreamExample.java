package ch17.sec01;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        //Set 컬렉션 생성
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신용권");
        set.add("감자바");
        //Stream을 이용한 요소 반복 처리
        Stream<String> stream = set.stream();
        //해당 코드는 consumer 형태로 되어있음을 볼 수 있다
        stream.forEach(name -> System.out.println(name));
        //stream.forEach(System.out::println); 메서드 참조 과정에서 매개변수와 출력 요소가 같다면 람다식으로 줄일 수 있다.
        //실제로 forEach를 세부적으로 살펴보면
        //void forEach(Consumer<? super T> action);와 같은 형태로 되어있다.
    }
}
