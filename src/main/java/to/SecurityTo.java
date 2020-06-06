package to;

import model.Security;

import java.time.LocalDateTime;

public class SecurityTo {

    private int id;
    private String secid;
    private String name;
    private String eminentTitle;


    // OR in a list of History?
    private LocalDateTime tradeDate;
    private double numTrades;
    private double open;
    private double close;


    public SecurityTo(Security sec) {
        this(sec.getId(), sec.getSecid(), sec.getName(), sec.getEminentTitle());
    }

    public SecurityTo(int id, String secid, String name, String eminentTitle) {
        this.id = id;
        this.secid = secid;
        this.name = name;
        this.eminentTitle = eminentTitle;
    }

    public SecurityTo(int id, String secid, String name, String eminentTitle, LocalDateTime tradeDate, double numTrades, double open, double close) {
        this.id = id;
        this.secid = secid;
        this.name = name;
        this.eminentTitle = eminentTitle;
        this.tradeDate = tradeDate;
        this.numTrades = numTrades;
        this.open = open;
        this.close = close;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEminentTitle() {
        return eminentTitle;
    }

    public void setEminentTitle(String eminentTitle) {
        this.eminentTitle = eminentTitle;
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
