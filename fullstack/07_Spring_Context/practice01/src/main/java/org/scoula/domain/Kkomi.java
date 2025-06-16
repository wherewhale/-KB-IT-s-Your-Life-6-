package org.scoula.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("꼬미")
public class Kkomi extends Dog{
    @PostConstruct
    public void init() {
        this.setName("꼬미");
        this.setBreed("푸들");
    }
}
