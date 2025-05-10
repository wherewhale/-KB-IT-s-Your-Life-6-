package ch18.sec10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class Product implements Serializable {
    private String name;
    private int price;

    @Override
    public String toString() {
        return name + ": " + price;
    }
}
