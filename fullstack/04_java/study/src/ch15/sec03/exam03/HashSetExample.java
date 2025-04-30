package ch15.sec03.exam03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        Iterator<String> iterator = set.iterator();
        // hasNext : 다음 값이 있는지 확인하는 메소드
        while (iterator.hasNext()) {
            // next : 다음 값을 가져오는 메소드
            String element = iterator.next();
            System.out.println(element);
            if (element.equalsIgnoreCase(("JSP"))) {
                // remove : 가져온 값을 컬렉션에서 제거하는 메소드
                iterator.remove();
            }
        }

        System.out.println();

        for (String element : set) {
            System.out.println(element);
        }

    }
}
