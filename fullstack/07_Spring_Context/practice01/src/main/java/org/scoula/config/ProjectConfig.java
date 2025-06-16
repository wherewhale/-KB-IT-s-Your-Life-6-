package org.scoula.config;

import org.scoula.domain.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.scoula")
public class ProjectConfig {
    //
    //@Bean(name = "d1")
    //Dog dog1() {
    //    var d = new Dog();
    //    d.setName("꼬미");
    //    d.setBreed("푸들");
    //    return d;
    //}
    //
    //@Bean(name = "d2")
    //Dog dog2() {
    //    var d = new Dog();
    //    d.setName("밤비");
    //    d.setBreed("시바견");
    //    return d;
    //}
    //
    //@Bean(name = "d3")
    //Dog dog3() {
    //    var d = new Dog();
    //    d.setName("해피");
    //    d.setBreed("진돗개");
    //    return d;
    //}

}
