package com.fin.stock.stockanalysismicroservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="stock-data-service")
public interface StockDataServiceProxy {

    @GetMapping("/stock-data-service/stock-data-service/{symbol}")
    public EnrichedStockData retrieveStockData(@PathVariable("symbol") String symbol);
}
