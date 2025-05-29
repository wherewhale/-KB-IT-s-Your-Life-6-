package org.scoula.jdbc_ex.dao;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.vo.SushiLogStat;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SushiDaoTest {
    SushiDao dao = new SushiDaoImpl();
    @BeforeEach
    void setUp() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM sushi_log");
        conn.createStatement().executeUpdate("DELETE FROM customer");

        dao.insertCustomer("cust01", "김초밥");
        dao.insertSushiLog("cust01", "red");
        dao.insertSushiLog("cust01", "blue");
        dao.insertSushiLog("cust01", "gold");
        dao.insertSushiLog("cust01", "blue");
        dao.insertSushiLog("cust01", "gold");
    }
    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    @Test
    @DisplayName("고객 추가")
    void insertCustomer() {
        int count = dao.insertCustomer("cust02", "이연어");
        Assertions.assertEquals(1, count);
    }

    @Test
    void insertSushiLog() {
        int count = dao.insertSushiLog("cust01", "red");
        Assertions.assertEquals(1, count);
    }

    @Test
    @DisplayName("고객의 접시 기록을 콘솔에 출력한다")
    void testPrintSushiLogByCustomer() throws SQLException {
        dao.printSushiLogByCustomer("cust01");
    }

    @Test
    @DisplayName("고객의 최애 접시 색상을 콘솔에 출력한다")
    void testFindFavoriteColor() throws SQLException {
        Optional<SushiLogStat> ss = dao.findFavoriteColor("cust01");
        ss.ifPresent(sushiLogStat -> System.out.println("cust01 고객님의 " + sushiLogStat));

    }
}