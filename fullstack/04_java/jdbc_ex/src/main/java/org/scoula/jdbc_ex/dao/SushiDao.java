package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.vo.SushiLogStat;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface SushiDao {
    int insertCustomer(String id, String name);

    int insertSushiLog(String customerId, String plateColor);

    void printSushiLogByCustomer(String customerId) throws SQLException;

    Optional<SushiLogStat> findFavoriteColor(String customerId) throws SQLException;

    List<String> getAllCustomerIds() throws SQLException;
}
