package org.scoula.food.service;

import lombok.RequiredArgsConstructor;
import org.scoula.food.dao.RestaurantDao;
import org.scoula.food.domain.RestaurantReviewVO;
import org.scoula.food.domain.RestaurantVO;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{
    final RestaurantDao dao;

    private int getNumber(String prompt) {
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        return num;
    }

    @Override
    public void printRestaurantWithReviews() {
        long id = getNumber("조회할 맛집 ID를 입력하세요: ");
        RestaurantVO restaurant = dao.getRestaurantWithReviews(id).orElseThrow(NoSuchElementException::new);
        System.out.println("\n[맛집 정보]");
        System.out.println("이름: " + restaurant.getName());
        System.out.println("카테고리: " + restaurant.getCategory());
        System.out.println("주소: " + restaurant.getAddress());
        System.out.println("설명: " + restaurant.getDescription());

        System.out.println("\n[리뷰 목록]");
        for(RestaurantReviewVO review : restaurant.getReviews()) {
            System.out.printf("- %s (%d점): %s\n", review.getWriter(), review.getScore(), review.getContent());
        }
    }

    @Override
    public void printAllRestaurantAvgScore() {
        AtomicInteger count = new AtomicInteger(1);
        System.out.println("맛집 평균 평점 순위");
        dao.getAllRestaurantWithScoreAvg().forEach(restaurant -> {
            System.out.printf("%d. %s (%.2f점) - %s\n", count.getAndIncrement(), restaurant.getName(), restaurant.getAverageScore(), restaurant.getAddress());
        });
    }


}
