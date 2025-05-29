package org.scoula.food.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantVO {
//    - `name` : 맛집 이름
//- `category` : 맛집 카테고리
//- `address` : 주소
//- `description` : 설명
    private String name;
    private String category;
    private String address;
    private String description;
    private Double averageScore;
    private List<RestaurantReviewVO> reviews;  // 리뷰 리스트 포함
}
