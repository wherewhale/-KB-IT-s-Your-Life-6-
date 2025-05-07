package practice11.exam02;


import lombok.Getter;

@Getter
public class Goods {
    private String name;
    private String color;
    private boolean useful;

    // 생성자, getter 3개
    public Goods(String name, String color, boolean useful) {
        this.name = name;
        this.color = color;
        this.useful = useful;
    }

}
