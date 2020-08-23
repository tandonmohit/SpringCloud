package com.fin.stock.stockdatamicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class StockDataController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment env;

    @Autowired
    private StockDataRepository repo;

    @GetMapping("/stock-data-service/{symbol}")
    public StockData retrieveStockData(@PathVariable String symbol) {

        StockData stock= repo.findBySymbol(symbol);
        //StockData stock= new StockData(1L,"TCS", BigDecimal.valueOf(2044));
        stock.setPort(Integer.parseInt(env.getProperty("local.server.port")));

        logger.info("{}",stock);

        return stock;
    }
}
