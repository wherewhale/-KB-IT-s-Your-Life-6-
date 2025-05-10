package ch18.sec10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class Member implements Serializable {
    private String id;
    private String name;

    @Override
    public String toString() {
        return id + ": " + name;
    }
}

