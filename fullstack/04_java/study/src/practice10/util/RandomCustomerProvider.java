package practice10.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomCustomerProvider {
    public static String getRandomCustomer() {
        String customers = "권경현, 권세림, 김동윤, 김미정, 김세연, 김승원, 김예림, 문정우, 민중원, 박준영, 서상훈, 손영호, 안수연, 안현주, 양성욱, 염정우, 이찬양, 이찬희, 이채은, 전경환, 정다연, 정수경, 최명진, 최은서, 최이주, 최지형, 최화진, 홍승원";
        List<String> customerList = Arrays.asList(customers.split(", "));

        Collections.shuffle(customerList);

        return customerList.get(0);
    }
}
