package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.dao.SushiDao;
import org.scoula.jdbc_ex.dao.SushiDaoImpl;
import org.scoula.jdbc_ex.vo.SushiLogStat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SushiFlowTest {

    private String CUSTOMER_ALL_GET_ID = "select id from customer";

    SushiDao dao = new SushiDaoImpl();

    @BeforeAll
    static void clearBeforeStart() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM sushi_log");
        conn.createStatement().executeUpdate("DELETE FROM customer");

        System.out.println("\uD83E\uDDF9 [BeforeAll] 전체 테이블 초기화 완료");
    }

    @AfterAll
    static void printEndMessage() {
        JDBCUtil.close();
        System.out.println("✅ [AfterAll] 모든 테스트 종료!");
    }

    @Test
    @Order(1)
    @DisplayName("1. 샘플 고객 및 기록 삽입")
    void insertSampleData() throws SQLException {
        dao.insertCustomer("cust01", "김초밥");
        dao.insertSushiLog("cust01", "red");
        dao.insertSushiLog("cust01", "blue");
        dao.insertSushiLog("cust01", "gold");
        System.out.println("\uD83D\uDCCC [1단계] 샘플 데이터 삽입 완료.");
    }

    @Test
    @Order(2)
    @DisplayName("2. 특정 고객 최애 접시 색상 분석")
    void printFavoriteColor() throws SQLException {
        Optional<SushiLogStat> ss = dao.findFavoriteColor("cust01");
        ss.ifPresent(sushiLogStat -> System.out.println("\uD83D\uDCCC [2단계] cust01 고객님의 " + sushiLogStat));
    }

    @Test
    @Order(3)
    @DisplayName("3. 전체 데이터 초기화")
    void resetData() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM sushi_log");
        conn.createStatement().executeUpdate("DELETE FROM customer");

        System.out.println("\uD83D\uDCCC [3단계] 모든 고객 및 기록이 삭제되었습니다.");
    }

    @Test
    @Order(4)
    @DisplayName("4. 다중 고객 삽입")
    void insertMultipleCustomers() throws SQLException{
        dao.insertCustomer("cust02", "이연어");
        dao.insertCustomer("cust03", "박광어");
        dao.insertSushiLog("cust02", "blue");
        dao.insertSushiLog("cust02", "blue");
        dao.insertSushiLog("cust02", "gold");
        dao.insertSushiLog("cust03", "red");
        dao.insertSushiLog("cust03", "gold");
        dao.insertSushiLog("cust03", "gold");
        System.out.println("\uD83D\uDCCC [4단계] 다중 고객 데이터 삽입 완료.");
    }

    @Test
    @Order(5)
    @DisplayName("5. 전체 고객 통계 출력")
    void printAllStats() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        try(PreparedStatement stmt = conn.prepareStatement(CUSTOMER_ALL_GET_ID)){
            List<String> customerList = new ArrayList<>();
            try(ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    customerList.add(rs.getString("id"));
                }
            }

            customerList.forEach(customerName -> {
                try {
                    Optional<SushiLogStat> ss = dao.findFavoriteColor(customerName);
                    ss.ifPresent(sushiLogStat -> System.out.println("- " + customerName + " 고객님의 " + sushiLogStat));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
