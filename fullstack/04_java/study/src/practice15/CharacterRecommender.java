package practice15;

import java.util.HashMap;
import java.util.Map;

public class CharacterRecommender {
    Map<String, DatingCharacter> map;

    public CharacterRecommender() {
        map = new HashMap<>();
    }

    public void putCharacter(String personality, DatingCharacter dc) {
        map.put(personality, dc);
    }

}
