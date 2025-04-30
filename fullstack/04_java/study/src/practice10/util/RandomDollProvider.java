package practice10.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomDollProvider {
    public static String getRandomDoll() {
        String dolls = "피카츄, 리자몽, 꼬부기, 쿠로미, 헬로키티, 뽀로로, 짱구, 도라에몽, 스폰지밥, 미니언";
        List<String> dollList = Arrays.asList(dolls.split(", "));

        Collections.shuffle(dollList);

        return dollList.get(0);
    }
}
