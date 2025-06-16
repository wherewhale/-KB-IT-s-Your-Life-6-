package org.scoula.app;

import org.scoula.config.ProjectConfig2;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig2.class);

        //Parrot p = context.getBean(Parrot.class);
        // 패럿 클래스가 여러개라 무엇을 가져올지 모르니 에러가 남
        Parrot p = context.getBean("miki", Parrot.class);
        //이름이 중복되지 않도록 지정하여 추출 가능
        System.out.println(p.getName());
    }

}
