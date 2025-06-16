package org.scoula.service;

import org.scoula.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RescueCenter {
    private final List<Dog> dogs;

    @Autowired
    public RescueCenter(List<Dog> dogs) {
        this.dogs = dogs;
    }

    @PostConstruct
    public void init() {
        Map<String, Integer> priorityMap = new HashMap<>();
        // 추가
        priorityMap.put("진돗개", 1);
        priorityMap.put("시바견", 2);
        priorityMap.put("푸들", 3);

        dogs.sort(Comparator.comparingInt(dog ->
                priorityMap.getOrDefault(dog.getBreed(), Integer.MAX_VALUE)
        ));

        System.out.println("📋 구조 우선순위에 따라 구조를 시작합니다!");
        dogs.forEach((dog) -> System.out.println("🫂 안아줌 완료: [" + dog.getBreed() + "] " + dog.getName()));
    }

}
