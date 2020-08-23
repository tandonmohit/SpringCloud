package com.fin.stock.stockanalysismicroservice;

import java.math.BigDecimal;

public class EnrichedStockData {


    private Long id;
    private String symbol;
    private BigDecimal price;

    private BigDecimal hiPrice;
    private BigDecimal loPrice;
    private int port;

    public BigDecimal getHiPrice() {
        return hiPrice;
    }

    public void setHiPrice(BigDecimal hiPrice) {
        this.hiPrice = hiPrice;
    }

    public BigDecimal getLoPrice() {
        return loPrice;
    }

    public void setLoPrice(BigDecimal loPrice) {
        this.loPrice = loPrice;
    }


    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public EnrichedStockData() {
    }

    public EnrichedStockData(Long id, String symbol, BigDecimal price) {
        this.id = id;
        this.symbol = symbol;
        this.price = price;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
