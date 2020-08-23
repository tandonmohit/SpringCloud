package com.fin.stock.stockdatamicroservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class StockData {

    @Id
    private Long id;
    @Column(name="symbol")
    private String symbol;
    private BigDecimal price;
    private int port;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public StockData() {
    }

    public StockData(Long id, String symbol, BigDecimal price) {
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
