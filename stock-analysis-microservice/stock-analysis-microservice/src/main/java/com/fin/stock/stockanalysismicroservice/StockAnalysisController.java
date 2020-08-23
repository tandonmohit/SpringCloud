package com.fin.stock.stockanalysismicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StockAnalysisController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment env;

    @Autowired
    private StockDataServiceProxy proxy;

    @GetMapping("/stock-analysis-service/{symbol}")
    public EnrichedStockData retrieveChosenStockData(@PathVariable String symbol) {

        Map<String,String> urivar= new HashMap<>();
        urivar.put("symbol",symbol);

        ResponseEntity<EnrichedStockData> resp=
        new RestTemplate().getForEntity("http://localhost:8000/stock-data-service/{symbol}",EnrichedStockData.class,urivar);

        EnrichedStockData stock=resp.getBody();

        EnrichedStockData enrichedData = new EnrichedStockData();
        enrichedData.setHiPrice(BigDecimal.valueOf(2500));
        enrichedData.setLoPrice(BigDecimal.valueOf(1500));
        enrichedData.setId(stock.getId());
        enrichedData.setPrice(stock.getPrice());
        enrichedData.setSymbol(stock.getSymbol());
        return enrichedData;
    }


    @GetMapping("/stock-analysis-service-feign/{symbol}")
    public EnrichedStockData retrieveChosenStockDataFeign(@PathVariable String symbol) {

        EnrichedStockData stock= proxy.retrieveStockData(symbol);

        EnrichedStockData enrichedData = new EnrichedStockData();
        enrichedData.setHiPrice(BigDecimal.valueOf(2500));
        enrichedData.setLoPrice(BigDecimal.valueOf(1500));
        enrichedData.setId(stock.getId());
        enrichedData.setPrice(stock.getPrice());
        enrichedData.setSymbol(stock.getSymbol());
        enrichedData.setPort(stock.getPort());

        logger.info("Stock Analysis-> {}",enrichedData);

        return enrichedData;
    }
}
