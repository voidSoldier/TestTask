package model;

import java.time.LocalDateTime;

public class History {

    private LocalDateTime tradeDate;
    private double numTrades;
    private double open;
    private double close;
    private String secid;

    public History() {
    }

    public History(LocalDateTime tradeDate, double numTrades, double open, double close, String secid) {
        this.tradeDate = tradeDate;
        this.numTrades = numTrades;
        this.open = open;
        this.close = close;
        this.secid = secid;
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

    public String getSecid() {
        return secid;
    }

    public void setSecid(String secid) {
        this.secid = secid;
    }
}
