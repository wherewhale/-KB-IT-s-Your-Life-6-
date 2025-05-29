package org.scoula.food.dao;

import org.scoula.food.domain.RestaurantReviewVO;
import org.scoula.food.domain.RestaurantVO;

import java.util.List;
import java.util.Optional;

public interface RestaurantDao {
    void insert(RestaurantVO restaurant);

    void insertReview(RestaurantReviewVO review);

    Optional<RestaurantVO> getRestaurantWithReviews(Long id);

    List<RestaurantVO> getAllRestaurantWithScoreAvg();
}
