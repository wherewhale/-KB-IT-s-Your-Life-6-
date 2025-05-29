package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.UserVO;
import org.scoula.jdbc_ex.vo.SushiLogStat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class SushiDaoImpl implements SushiDao {
    Connection conn = JDBCUtil.getConnection();

    private String CUSTOMER_INSERT = "insert into customer values(?, ?)";
    private String CUSTOMER_ALL_GET_ID = "select id from customer";
    private String SUSHI_LOG_INSERT = "insert into sushi_log(customer_id, plate_color) values(?, ?)";
    private String SUSHI_LOG_BY_CUSTOMER = "select * from sushi_log where customer_id = ? order by eaten_at desc";
    private String SUSHI_LOG_GET_BEST = "select plate_color, count(*) as COUNT from sushi_log where customer_id = ? group by plate_color order by count(*) desc limit 1";


    private SushiLogStat map(ResultSet rs) throws SQLException {
        SushiLogStat ss = new SushiLogStat();

        ss.setPlateColor(rs.getString("plate_color"));
        ss.setCount(rs.getInt("COUNT"));

        return ss;
    }

    @Override
    public int insertCustomer(String id, String name) {
        try(PreparedStatement stmt = conn.prepareStatement(CUSTOMER_INSERT)) {
            stmt.setString(1, id);
            stmt.setString(2, name);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insertSushiLog(String customerId, String plateColor) {
        try(PreparedStatement stmt = conn.prepareStatement(SUSHI_LOG_INSERT)) {
            stmt.setString(1, customerId);
            stmt.setString(2, plateColor);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void printSushiLogByCustomer(String customerId) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(SUSHI_LOG_BY_CUSTOMER)) {
            stmt.setString(1, customerId);
            ResultSet rs = stmt.executeQuery();
            System.out.println("[고객 ID: " + customerId + "] 의 접시 기록");
            int i = 1;
            while (rs.next()) {
                String color = rs.getString("plate_color");
                String eatenAt = rs.getString("eaten_at");
                System.out.println(i++ + ". " + String.format("%-6s", color) + " (" + eatenAt + ")");
            }
        }
    }

    @Override
    public Optional<SushiLogStat> findFavoriteColor(String customerId) throws SQLException {
        try(PreparedStatement stmt = conn.prepareStatement(SUSHI_LOG_GET_BEST)){
            stmt.setString(1, customerId);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    return Optional.of(map(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<String> getAllCustomerIds() throws SQLException {
        try(PreparedStatement stmt = conn.prepareStatement(CUSTOMER_ALL_GET_ID)){
            List<String> customerList = new ArrayList<>();
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    customerList.add(rs.getString("id"));
                }
            }

            return customerList;
        }
    }

}
