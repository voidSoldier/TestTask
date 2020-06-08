package com.javajunior.testtask;

import com.javajunior.testtask.model.History;
import com.javajunior.testtask.model.Security;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecParser {


    private List<Security> securityList;
    private List<History> historyList;
    private Map<List<Security>, List<History>> result;

    public SecParser() {
        securityList = new ArrayList<>();
        historyList = new ArrayList<>();
        result = new HashMap<>();
    }

    public Map<List<Security>, List<History>> parse(List<String> fileNames) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc;

        for (String fileName : fileNames) {
            doc = dBuilder.parse(new File(fileName));
            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();


            Element dataType = doc.getElementById("data");
            if (dataType.getAttribute("id").equals("security")) {
                parseSecurity(doc);
            } else parseHistory(doc);
        }


        matchHistoryToSecurity();
        result.put(securityList, historyList);
        return result;
    }

    private void parseSecurity(Document doc) {
        Security newSec = new Security();
        NodeList nodes = doc.getElementsByTagName("row");

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
//
                Element e = (Element) node;
//                newSec.setId(Integer.parseInt(e.getAttribute("id")));
//                newSec.setSecid(e.getAttribute("secid"));
//                newSec.setShortName(e.getAttribute("short_name"));
//                newSec.setRegNumber(e.getAttribute("reg_number"));
//                newSec.setName(e.getAttribute("name"));
//                newSec.setIsin(e.getAttribute("isin"));
//                newSec.setIsTraded(Integer.parseInt(e.getAttribute("is_traded")));
//                newSec.setEmitentId(Integer.parseInt(e.getAttribute("emitent_id")));
//                newSec.setEmitentTitle(e.getAttribute("emitent_title"));
//                newSec.setEmitentInn(e.getAttribute("emitent_inn"));
//                newSec.setEmitentOkpo(e.getAttribute("emitent_okpo"));
//                newSec.setGosReg(e.getAttribute("gos_reg"));
//                newSec.setType(e.getAttribute("type"));
//                newSec.setGroup(e.getAttribute("group"));
//                newSec.setPrimaryBoardId(e.getAttribute("primary_board_id"));
//                newSec.setMarketPriceBoardId(e.getAttribute("market_price_board_id"));

                newSec.setId(getInt(e, "id"));
                newSec.setSecid(getStr(e, "secid"));
                newSec.setShortName(getStr(e, "shortname"));
                newSec.setRegNumber(getStr(e, "regnumber"));
                newSec.setName(getStr(e, "name"));
                newSec.setIsin(getStr(e, "isin"));
                newSec.setIsTraded(getInt(e, "is_traded"));
                newSec.setEmitentId(getInt(e, "emitent_id"));
                newSec.setEmitentTitle(getStr(e, "emitent_title"));
                newSec.setEmitentInn(getStr(e, "emitent_inn"));
                newSec.setEmitentOkpo(getStr(e, "emitent_okpo"));
                newSec.setGosReg(getStr(e, "gosreg"));
                newSec.setType(getStr(e, "type"));
                newSec.setGroup(getStr(e, "group"));
                newSec.setPrimaryBoardId(getStr(e, "primary_boardid"));
                newSec.setMarketPriceBoardId(getStr(e, "marketprice_boardid"));

            }
        }

        securityList.add(newSec);
    }

    private String getStr(Element e, String attr) {
        return e.getAttribute(attr);
    }
    private int getInt(Element e, String attr) {
        return Integer.parseInt(e.getAttribute(attr));
    }
    private double getDouble(Element e, String attr) {
        return Double.parseDouble(e.getAttribute(attr));
    }


    private void parseHistory(Document doc) {
        History newHist = new History();

        NodeList nodes = doc.getElementsByTagName("row");

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element e = (Element) node;
//                newHist.setTradeDate(LocalDateTime.parse(e.getAttribute("TRADEDATE")));
//                newHist.setSecid((e.getAttribute("SECID")));
//                newHist.setNumTrades(Double.parseDouble(e.getAttribute("NUMTRADES")));
//                newHist.setOpen(Double.parseDouble(e.getAttribute("OPEN")));
//                newHist.setClose(Double.parseDouble(e.getAttribute("CLOSE")));

                newHist.setBoardId(getStr(e, "BOARDID"));
                newHist.setTradeDate(LocalDateTime.parse(getStr(e, "TRADEDATE")));
                newHist.setShortName(getStr(e, "SHORTNAME"));
                newHist.setSecid(getStr(e, "SECID"));
                newHist.setNumTrades(getDouble(e, "NUMTRADES"));
                newHist.setValue(getDouble(e, "VALUE"));
                newHist.setOpen(getDouble(e, "OPEN"));
                newHist.setLow(getDouble(e, "LOW"));
                newHist.setHigh(getDouble(e, "HIGH"));
                newHist.setLegalClosePrice(getDouble(e, "LEGALCLOSEPRICE"));
                newHist.setWaPrice(getDouble(e, "WAPRICE"));
                newHist.setClose(getDouble(e, "CLOSE"));
                newHist.setVolume(getDouble(e, "VOLUME"));
                newHist.setMarketPrice2(getDouble(e, "MARKETPRICE2"));
                newHist.setMarketPrice3(getDouble(e, "MARKETPRICE3"));
                newHist.setAdmittedQuote(getDouble(e, "ADMITTEDQUOTE"));
                newHist.setMp2ValTrd(getDouble(e, "MP2VALTRD"));
                newHist.setMarketPrice3TradesValue(getDouble(e, "MARKETPRICE3TRADESVALUE"));
                newHist.setAdmittedValue(getDouble(e, "ADMITTEDVALUE"));
                newHist.setWaVal(getDouble(e, "WAVAL"));
            }
        }

        historyList.add(newHist);
    }

    private void matchHistoryToSecurity() {
        for (Security sec : securityList) {
            String secid = sec.getSecid().toLowerCase();
            for (History hist : historyList) {
                if (secid.equals(hist.getSecid().toLowerCase())) {
                    hist.setSecurity(sec);
                    sec.addHistory(hist);
                }
            }
        }
    }
}
