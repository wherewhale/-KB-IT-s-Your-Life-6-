package ch16.sec05.exam02;

@FunctionalInterface
public interface Comparable {
    //String 객체는 이미 compare 객체가 구현되어있음
    int compare(String a, String b);
}
