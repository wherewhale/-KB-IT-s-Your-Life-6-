package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.domain.Dog;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Dog d1 = context.getBean("d1", Dog.class);
        Dog d2 = context.getBean("d2", Dog.class);
        Dog d3 = context.getBean("d3", Dog.class);
        System.out.println("[1] 등록된 강아지 목록:");
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
    }
}
