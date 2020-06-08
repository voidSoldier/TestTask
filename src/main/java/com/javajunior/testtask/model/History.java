package com.javajunior.testtask.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


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
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime tradeDate;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "secid")
    @NotBlank
    private String secid;

    @Column(name = "num_trades")
    @NotNull
    private double numTrades;

    @Column(name = "value")
    private double value;

    @Column(name = "open")
    @NotNull
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
    @NotNull
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

//    public History(String boardId, @NotNull LocalDateTime tradeDate, String shortName, @NotBlank String secid,
//                   @NotNull double numTrades, double value, @NotNull double open, double low, double high, double legalClosePrice,
//                   double waPrice, @NotNull double close, double volume, double marketPrice2, double marketPrice3, double admittedQuote,
//                   double mp2ValTrd, double marketPrice3TradesValue, double admittedValue, double waVal, Security security) {
//        this.boardId = boardId;
//        this.tradeDate = tradeDate;
//        this.shortName = shortName;
//        this.secid = secid;
//        this.numTrades = numTrades;
//        this.value = value;
//        this.open = open;
//        this.low = low;
//        this.high = high;
//        this.legalClosePrice = legalClosePrice;
//        this.waPrice = waPrice;
//        this.close = close;
//        this.volume = volume;
//        this.marketPrice2 = marketPrice2;
//        this.marketPrice3 = marketPrice3;
//        this.admittedQuote = admittedQuote;
//        this.mp2ValTrd = mp2ValTrd;
//        this.marketPrice3TradesValue = marketPrice3TradesValue;
//        this.admittedValue = admittedValue;
//        this.waVal = waVal;
//        this.security = security;
//    }
//
//    // with String secid
//    public History(LocalDateTime tradeDate, double numTrades, double open, double close, String secid) {
//        this.tradeDate = tradeDate;
//        this.numTrades = numTrades;
//        this.open = open;
//        this.close = close;
//        this.secid = secid;
//    }
//
////    // with Security object
//    public History(LocalDateTime tradeDate, double numTrades, double open, double close, Security security) {
//        this.tradeDate = tradeDate;
//        this.numTrades = numTrades;
//        this.open = open;
//        this.close = close;
//        this.security = security;
//        this.secid = security.getSecid();
//    }

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

    public LocalDateTime getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDateTime tradeDate) {
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
