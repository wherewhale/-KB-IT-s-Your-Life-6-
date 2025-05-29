package org.scoula.food.dataimport;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.scoula.food.dao.RestaurantDao;
import org.scoula.food.dao.RestaurantDaoImpl;
import org.scoula.food.domain.RestaurantReviewVO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ImportReviewData {
    public static void main(String[] args) throws CsvValidationException, IOException {
        RestaurantDao dao = new RestaurantDaoImpl();

        List<RestaurantReviewVO> reviews = new CsvToBeanBuilder<RestaurantReviewVO>(new FileReader("reviews_pokemon.csv"))
                    .withType(RestaurantReviewVO.class)
                    .build()
                    .parse();

        reviews.forEach(review -> {
            dao.insertReview(review);
            System.out.println("✅ 저장됨: " + review.getWriter() + " -> " + review.getScore());
        });
    }
}
