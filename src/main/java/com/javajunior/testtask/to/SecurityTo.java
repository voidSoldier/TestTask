package com.javajunior.testtask.to;

import com.javajunior.testtask.model.Security;

import java.time.LocalDateTime;

public class SecurityTo {

    private int id;
    private String secid;
    private String name;
    private String emitentTitle;


    // OR in a list of History?
    private LocalDateTime tradeDate;
    private double numTrades;
    private double open;
    private double close;


    public SecurityTo(Security sec) {
//        int id = sec.getId();
//        String secid = sec.getSecid();
//        String name = sec.getName();
//        String emitentTitle =  sec.getEmitentTitle();


        this(sec.getId(), sec.getSecid(), sec.getName(), sec.getEmitentTitle());
    }

    private SecurityTo(int id, String secid, String name, String emitentTitle) {
        this.id = id;
        this.secid = secid;
        this.name = name;
        this.emitentTitle = emitentTitle;
    }

//    public SecurityTo(int id, String secid, String name, String emitentTitle, LocalDateTime tradeDate, double numTrades, double open, double close) {
//        this.id = id;
//        this.secid = secid;
//        this.name = name;
//        this.emitentTitle = emitentTitle;
//        this.tradeDate = tradeDate;
//        this.numTrades = numTrades;
//        this.open = open;
//        this.close = close;
//    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmitentTitle() {
        return emitentTitle;
    }

    public void setEmitentTitle(String eminentTitle) {
        this.emitentTitle = eminentTitle;
    }

    public LocalDateTime getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDateTime tradeDate) {
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
