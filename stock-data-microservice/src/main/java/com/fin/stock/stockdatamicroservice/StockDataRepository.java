package com.fin.stock.stockdatamicroservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockDataRepository extends JpaRepository<StockData,Long> {
    StockData findBySymbol(String symbol);
}
