package com.javajunior.stockdataparser.to;

import com.javajunior.stockdataparser.model.Security;

import java.time.LocalDate;

public class SecurityTo {

    private int id;
    private String secid;
    private String regNumber;
    private String name;
    private String emitentTitle;

    private LocalDate tradeDate;
    private double numTrades;
    private double open;
    private double close;

    public SecurityTo(Security sec) {
        this(sec.getId(), sec.getSecid(), sec.getRegNumber(), sec.getName(), sec.getEmitentTitle());
    }

    private SecurityTo(int id, String secid, String regNumber, String name, String emitentTitle) {
        this.secid = secid;
        this.regNumber = regNumber;
        this.name = name;
        this.emitentTitle = emitentTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecid() {
        return secid;
    }

    public void setSecid(String secid) {
        this.secid = secid;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmitentTitle() {
        return emitentTitle;
    }

    public void setEmitentTitle(String emitentTitle) {
        this.emitentTitle = emitentTitle;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public double getNumTrades() {
        return numTrades;
    }

    public void setNumTrades(double numTrades) {
        this.numTrades = numTrades;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }
}
