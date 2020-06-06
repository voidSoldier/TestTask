package model;

import java.util.List;

public class Security {

    private int id;
    private String secid;
    private String name;
    private String eminentTitle;
    private List<History> histories;

    public Security() {
    }

    public Security(int id, String secid, String name, String eminentTitle) {
        this.id = id;
        this.secid = secid;
        this.name = name;
        this.eminentTitle = eminentTitle;
    }


    public void addHistory(History h) {
        histories.add(h);


    } public void addHistory(List<History> h) {
        histories.addAll(h);
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

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }
}
