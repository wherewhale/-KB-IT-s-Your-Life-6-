package org.scoula.stock.service;

import org.scoula.stock.dto.StockDTO;

import java.util.List;

public interface StockService {
    public List<StockDTO> getList();
}
