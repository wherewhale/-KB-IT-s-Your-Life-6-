package org.scoula.stock.mapper;

import org.scoula.stock.domain.StockVO;

import java.util.List;

public interface StockMapper {
    public List<StockVO> getList();
}
