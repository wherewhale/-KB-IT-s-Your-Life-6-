package ch17.sec12.exam01;

import java.util.ArrayList;
import java.util.List;

public class CollectExample {
    public static void main(String[] args) {
        List<Student> totalList = new ArrayList<>();
        totalList.add(new Student("홍길동", "남", 92));
        totalList.add(new Student("김수영", "여", 87));
        totalList.add(new Student("감자바", "남", 95));
        totalList.add(new Student("오해영", "여", 93));

        //스트림을 사용하지 않는 경우
        //List<Student> maleList = new ArrayList<>();
        //for (Student student : totalList) {
        //    if (student.getSex().equals("남")) {
        //        maleList.add(student);
        //    }
        //}

        //스트림을 사용하는 경우
        //List<Student> maleList = totalList.stream()
        //        .filter(s -> s.getSex().equals("남"))
        //        //.peek(student -> System.out.println(student.getName()))
        //        .toList();
        //
        //maleList.stream()
        //        .forEach(s -> System.out.println(s.getName()));
        //
        //maleList.stream()
        //        .map(Student::getName)
        //        .forEach(System.out::println);

        List<Student> orderedList = totalList.stream()
                .sorted((a, b) -> Integer.compare(b.getScore(), a.getScore()))
                .limit(2)
                .peek(student -> System.out.println(student.getName()))
                .toList();


    }

}
