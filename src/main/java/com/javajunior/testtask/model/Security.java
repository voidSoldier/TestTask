package com.javajunior.testtask.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "securities", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "secid"}, name = "security_unique_name_secid_idx")})
public class Security {

    @Id
//    @Column(columnDefinition = "INTEGER")
    private int id;

    @Column(name = "secid", nullable = false, unique = true)
    @NotBlank
    private String secid;

    @Column(name = "short_name", nullable = false)
    private String shortName;

    @Column(name = "reg_number", nullable = false)
    private String regNumber;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "isin", nullable = false)
    private String isin;

    @Column(name = "is_traded", nullable = false)
    private int isTraded;

    @Column(name = "emitent_id", nullable = false)
    private int emitentId;

    @Column(name = "emitent_title", nullable = false)
    private String emitentTitle;

    @Column(name = "emitent_inn", nullable = false)
    private String emitentInn;

    @Column(name = "emitent_okpo", nullable = false)
    private String emitentOkpo;

    @Column(name = "gos_reg", nullable = false)
    private String gosReg;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "sec_group", nullable = false)
    private String group;

    @Column(name = "primary_board_id", nullable = false)
    private String primaryBoardId;

    @Column(name = "marketprice_board_id", nullable = false)
    private String marketPriceBoardId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "security")//, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderBy("tradeDate DESC")
    private List<History> histories;

    public Security() {
    }

//    public Security(int id, String secid, String name, String emitentTitle) {
//        this.id = id;
//        this.secid = secid;
//        this.name = name;
//        this.emitentTitle = emitentTitle;
//    }


    public Security(@NotEmpty int id, @NotBlank String secid, String shortName, String regNumber,
                    @NotBlank String name, String isin, int isTraded, int emitentId, @NotBlank String emitentTitle, String emitentInn,
                    String emitentOkpo, String gosReg, String type, String group, String primaryBoardId, String marketPriceBoardId) {
        this.id = id;
        this.secid = secid;
        this.shortName = shortName;
        this.regNumber = regNumber;
        this.name = name;
        this.isin = isin;
        this.isTraded = isTraded;
        this.emitentId = emitentId;
        this.emitentTitle = emitentTitle;
        this.emitentInn = emitentInn;
        this.emitentOkpo = emitentOkpo;
        this.gosReg = gosReg;
        this.type = type;
        this.group = group;
        this.primaryBoardId = primaryBoardId;
        this.marketPriceBoardId = marketPriceBoardId;
    }

    public void addHistory(History h) {
        if (histories == null) {
            histories = new ArrayList<>();
        }
        histories.add(h);
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
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

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public int getIsTraded() {
        return isTraded;
    }

    public void setIsTraded(int isTraded) {
        this.isTraded = isTraded;
    }

    public int getEmitentId() {
        return emitentId;
    }

    public void setEmitentId(int emitentId) {
        this.emitentId = emitentId;
    }

    public String getEmitentTitle() {
        return emitentTitle;
    }

    public void setEmitentTitle(String emitentTitle) {
        this.emitentTitle = emitentTitle;
    }

    public String getEmitentInn() {
        return emitentInn;
    }

    public void setEmitentInn(String emitentInn) {
        this.emitentInn = emitentInn;
    }

    public String getEmitentOkpo() {
        return emitentOkpo;
    }

    public void setEmitentOkpo(String emitentOkpo) {
        this.emitentOkpo = emitentOkpo;
    }

    public String getGosReg() {
        return gosReg;
    }

    public void setGosReg(String gosReg) {
        this.gosReg = gosReg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPrimaryBoardId() {
        return primaryBoardId;
    }

    public void setPrimaryBoardId(String primaryBoardId) {
        this.primaryBoardId = primaryBoardId;
    }

    public String getMarketPriceBoardId() {
        return marketPriceBoardId;
    }

    public void setMarketPriceBoardId(String marketPriceBoardId) {
        this.marketPriceBoardId = marketPriceBoardId;
    }

    public List<History> getHistories() {
        return histories == null ? new ArrayList<>() : histories;
    }

    public void setHistories(List<History> hist) {
        if (histories != null) histories.addAll(hist);
        hist = histories;
    }
}
