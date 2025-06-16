package org.scoula.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("밤비")
public class Bambi extends Dog{
    public Bambi() {
        setName("밤비");
        setBreed("시바견");
    }
}
