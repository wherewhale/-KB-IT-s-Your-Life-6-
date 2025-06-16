package org.scoula.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("해피")
public class Happy extends Dog{
    @PostConstruct
    public void init() {
        this.setName("해피");
        this.setBreed("진돗개");
    }
}
