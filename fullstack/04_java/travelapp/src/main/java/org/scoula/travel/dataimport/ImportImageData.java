package org.scoula.travel.dataimport;

import org.scoula.dao.TravelDao;
import org.scoula.dao.TravelDaoImpl;
import org.scoula.database.JDBCUtil;
import org.scoula.domain.TravelImageVO;

import java.io.File;

public class ImportImageData {
    public static void main(String[] args) {
        TravelDao dao = new TravelDaoImpl();

        File dir = new File("../travel-image"); //부모 디렉토리로 설정
        File[] files = dir.listFiles();
        for (File file : files) {
            String filename = file.getName(); //getName으로 확장자 제외 파일명 얻어옴
            long travelNo = Long.parseLong(filename.split("-")[0]); //관광지 no 얻기

            //빌더 패턴 사용
            TravelImageVO image = TravelImageVO.builder()
                    .filename(filename)
                    .travelNo(travelNo)
                    .build();

            System.out.println(image);
            dao.insertImage(image);
        }

        JDBCUtil.close();
    }
}
