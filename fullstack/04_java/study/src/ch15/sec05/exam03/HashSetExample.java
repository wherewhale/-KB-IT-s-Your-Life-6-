package ch15.sec05.exam03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        //HashSet 컬렉션 생성
        Set<String> set = new HashSet<String>();
        //객체 추가
        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        //Iterator 패턴으로 순회하며 각 요소를 출력하세요.
        //객체를 하나씩 가져와서 처리
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            //객체를 하나 가져오기
            String element = iterator.next();
            System.out.println(element);
        }

        System.out.println();

        //향상된 for 문으로  순회하며 각 요소를 출력하세요.
        for (String element : set) {
            System.out.println(element);
        }

    }
}
