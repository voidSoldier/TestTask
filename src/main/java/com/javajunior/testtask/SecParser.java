package com.javajunior.testtask;

import com.javajunior.testtask.model.History;
import com.javajunior.testtask.model.Security;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SecParser {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private List<Security> securityList;
    private List<History> historyList;

    public SecParser() {
        securityList = new ArrayList<>();
        historyList = new ArrayList<>();
    }

    public List<Security> getSecurityList(){
        return securityList;
    }

    public List<History> getHistoryList(){
        return historyList;
    }

    public void parse(MultipartFile[] files) throws ParserConfigurationException, IOException, SAXException {
        log.info("in the parse method");
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc;

        for (MultipartFile f : files) {
            doc = dBuilder.parse(f.getInputStream());
            //http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("data");
            Element e = (Element) nodes.item(0);
            if (("securities").equals(e.getAttribute("id"))) {
                parseSecurity(doc);
            } else parseHistory(doc);

        }

    }

    private void parseSecurity(Document doc) {
        log.info("in the parse SECURITY method");

        NodeList nodes = doc.getElementsByTagName("row");

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Security newSec = new Security();
                Element e = (Element) node;

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

                securityList.add(newSec);
            }
        }
    }

    private String getStr(Element e, String attr) {
        return e.getAttribute(attr);
    }

    private int getInt(Element e, String attr) {
        String attrStr = e.getAttribute(attr);
        return attrStr.isEmpty() || attrStr.isBlank() ? 0 : Integer.parseInt(attrStr);
    }

    private double getDouble(Element e, String attr) {
        String attrStr = e.getAttribute(attr);
        return attrStr.isEmpty() || attrStr.isBlank() ? 0 : Double.parseDouble(attrStr);
    }

    private LocalDate getDate(Element e) {
        String date = e.getAttribute("TRADEDATE");
        return date.isBlank() || date.isEmpty() ? null : LocalDate.parse(date);
    }


    private void parseHistory(Document doc) {
        log.info("in the parse HISTORY method");

        NodeList nodes = doc.getElementsByTagName("row");

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                History newHist = new History();
                Element e = (Element) node;

                newHist.setBoardId(getStr(e, "BOARDID"));
                newHist.setTradeDate(getDate(e));
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
                historyList.add(newHist);
            }
        }

    }

    public void matchHistoryToSecurity() {
        log.info("in the --matchHistoryToSecurity-- method");
        List<History> copy = new ArrayList<>();

        if (!securityList.isEmpty() || !historyList.isEmpty()) {
            for (History hist : historyList) {
                String secid = hist.getSecid().toLowerCase();
                for (Security sec : securityList) {
                    if (secid.equals(sec.getSecid().toLowerCase())) {
                        hist.setSecurity(sec);
                    }
                }
                if (hist.getSecurity() == null) copy.add(hist);
            }
        }
        historyList.removeAll(copy);
    }
}
