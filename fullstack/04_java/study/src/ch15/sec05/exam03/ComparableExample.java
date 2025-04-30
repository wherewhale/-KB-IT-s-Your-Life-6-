package ch15.sec05.exam03;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableExample {
    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("홍길동", 35));
        personList.add(new Person("감자바", 25));
        personList.add(new Person("박지원", 31));


        Collections.sort(personList);

        for (Person person : personList) {
            System.out.println(person.name);
        }
    }
}
