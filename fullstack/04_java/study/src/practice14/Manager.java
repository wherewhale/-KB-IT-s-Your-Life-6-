package practice14;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Product> showcase = new HashMap<>();

    public void register(String name, Product prototype) {
        showcase.put(name, prototype);
    }

    public Product create(String prototypeName) {
        return showcase.getOrDefault(prototypeName, null);
    }

    public void printRegisteredStyles() {
        System.out.println("[등록된 스타일 목록]");
        showcase.forEach((s, product) -> System.out.println("- " + s + " : " + ((CardTemplate) product).getTitle()));
    }
}
