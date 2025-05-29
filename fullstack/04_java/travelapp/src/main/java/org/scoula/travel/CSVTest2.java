package org.scoula.travel;

import com.opencsv.bean.CsvToBeanBuilder;
import org.scoula.domain.TravelVO;

import java.io.FileReader;
import java.util.List;

public class CSVTest2 {
    public static void main(String[] args) throws Exception {
        //TravelVO는 타입만 지정
        List<TravelVO> travels = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv"))
                .withType(TravelVO.class)//withType을 통해서 실제 클래스 정보를 넘긴 것 (Reflection 기법)
                .build()
                .parse();

        //메서드 참조를 통해서, 그대로 사용 (람다식으로 사용 가능)
        //travels.forEach(System.out::println);
        travels.forEach(travel -> {
            System.out.println(travel);
        });
    }
}

