package org.scoula.food.dao;

import org.scoula.database.JDBCUtil;
import org.scoula.food.domain.RestaurantReviewVO;
import org.scoula.food.domain.RestaurantVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantDaoImpl implements RestaurantDao {
    Connection conn = JDBCUtil.getConnection();

    private RestaurantVO map(ResultSet rs) throws SQLException {
        return RestaurantVO.builder()
                .name(rs.getString("name"))
                .category(rs.getString("category"))
                .address(rs.getString("address"))
                .description(rs.getString("description"))
                .averageScore(rs.getDouble("AVG_SCORE"))
                .build();
    }

    private RestaurantReviewVO mapReview(ResultSet rs) throws SQLException {
        return RestaurantReviewVO.builder()
                .restaurantId(rs.getLong("id"))
                .writer(rs.getString("writer"))
                .content(rs.getString("content"))
                .score(rs.getLong("score"))
                .build();
    }

    @Override
    public void insert(RestaurantVO restaurant) {
        String sql = "insert into tbl_restaurant(name, category, address, description) values(?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, restaurant.getName());
            pstmt.setString(2, restaurant.getCategory());
            pstmt.setString(3, restaurant.getAddress());
            pstmt.setString(4, restaurant.getDescription());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            //catch 절을 사용하면 insert에서 throws를 사용하지 않아도 되며, 강제 예외처리에 대한 부분을 조정할 수 있다.
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insertReview(RestaurantReviewVO review) {
        String sql = "INSERT INTO tbl_restaurant_review(restaurant_id, writer, content, score) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, review.getRestaurantId());
            pstmt.setString(2, review.getWriter());
            pstmt.setString(3, review.getContent());
            pstmt.setLong(4, review.getScore());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<RestaurantVO> getRestaurantWithReviews(Long id) {
        RestaurantVO restaurant = null;
        String sql = """
        
                SELECT r.*, rr.writer, rr.content, rr.score 
        FROM tbl_restaurant r 
        LEFT OUTER JOIN tbl_restaurant_review rr 
        ON r.id = rr.restaurant_id
        WHERE r.id = ?;
        """;

        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            {
                if(rs.next()) {
                    restaurant = map(rs);
                    List<RestaurantReviewVO> reviews = new ArrayList<>();

                    try {
                        do {
                            RestaurantReviewVO review = mapReview(rs);
                            reviews.add(review);
                        } while (rs.next());
                    } catch (SQLException e) {
                        //리뷰 없는 경우
                    }
                    restaurant.setReviews(reviews);
                    return Optional.of(restaurant);
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<RestaurantVO> getAllRestaurantWithScoreAvg() {
        List<RestaurantVO> restaurants = new ArrayList<>();
        String sql =
                """
                SELECT r.*, AVG(rr.score) as AVG_SCORE
                FROM tbl_restaurant r 
                LEFT OUTER JOIN
                tbl_restaurant_review rr
                ON r.id = rr.restaurant_id
                GROUP BY r.id         
                ORDER BY AVG(rr.score) DESC;
                """;

        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                restaurants.add(map(rs));
            }

            return restaurants;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

