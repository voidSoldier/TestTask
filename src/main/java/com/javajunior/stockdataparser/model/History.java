package com.javajunior.stockdataparser.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "histories")
public class History {

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer id;

    @Column(name = "board_id")
    private String boardId;

    @Column(name = "trade_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tradeDate;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "secid")
    private String secid;

    @Column(name = "num_trades")
    private double numTrades;

    @Column(name = "value")
    private double value;

    @Column(name = "open")
    private double open;

    @Column(name = "low")
    private double low;

    @Column(name = "high")
    private double high;

    @Column(name = "legal_close_price")
    private double legalClosePrice;

    @Column(name = "wa_price")
    private double waPrice;

    @Column(name = "close")
    private double close;

    @Column(name = "volume")
    private double volume;

    @Column(name = "market_price2")
    private double marketPrice2;

    @Column(name = "market_price3")
    private double marketPrice3;

    @Column(name = "admitted_quote")
    private double admittedQuote;

    @Column(name = "mp2_val_trd")
    private double mp2ValTrd;

    @Column(name = "market_price3_trades_value")
    private double marketPrice3TradesValue;

    @Column(name = "admitted_value")
    private double admittedValue;

    @Column(name = "wa_val")
    private double waVal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "security_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Security security;


    public History() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSecid() {
        return secid;
    }

    public void setSecid(String secid) {
        this.secid = secid;
    }

    public double getNumTrades() {
        return numTrades;
    }

    public void setNumTrades(double numTrades) {
        this.numTrades = numTrades;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLegalClosePrice() {
        return legalClosePrice;
    }

    public void setLegalClosePrice(double legalClosePrice) {
        this.legalClosePrice = legalClosePrice;
    }

    public double getWaPrice() {
        return waPrice;
    }

    public void setWaPrice(double waPrice) {
        this.waPrice = waPrice;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getMarketPrice2() {
        return marketPrice2;
    }

    public void setMarketPrice2(double marketPrice2) {
        this.marketPrice2 = marketPrice2;
    }

    public double getMarketPrice3() {
        return marketPrice3;
    }

    public void setMarketPrice3(double marketPrice3) {
        this.marketPrice3 = marketPrice3;
    }

    public double getAdmittedQuote() {
        return admittedQuote;
    }

    public void setAdmittedQuote(double admittedQuote) {
        this.admittedQuote = admittedQuote;
    }

    public double getMp2ValTrd() {
        return mp2ValTrd;
    }

    public void setMp2ValTrd(double mp2ValTrd) {
        this.mp2ValTrd = mp2ValTrd;
    }

    public double getMarketPrice3TradesValue() {
        return marketPrice3TradesValue;
    }

    public void setMarketPrice3TradesValue(double marketPrice3TradesValue) {
        this.marketPrice3TradesValue = marketPrice3TradesValue;
    }

    public double getAdmittedValue() {
        return admittedValue;
    }

    public void setAdmittedValue(double admittedValue) {
        this.admittedValue = admittedValue;
    }

    public double getWaVal() {
        return waVal;
    }

    public void setWaVal(double waVal) {
        this.waVal = waVal;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }
}
