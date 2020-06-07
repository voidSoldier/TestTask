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

                Element e = (Element) node;
                newSec.setId(Integer.parseInt(e.getAttribute("id")));
                newSec.setSecid(e.getAttribute("secid"));
                newSec.setName(e.getAttribute("name"));
                newSec.setEminentTitle(e.getAttribute("eminent_title"));
            }
        }

        securityList.add(newSec);
    }


    private void parseHistory(Document doc) {
        History newHist = new History();

        NodeList nodes = doc.getElementsByTagName("row");

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element e = (Element) node;
                newHist.setTradeDate(LocalDateTime.parse(e.getAttribute("TRADEDATE")));
                newHist.setSecid((e.getAttribute("SECID")));
                newHist.setNumTrades(Double.parseDouble(e.getAttribute("NUMTRADES")));
                newHist.setOpen(Double.parseDouble(e.getAttribute("OPEN")));
                newHist.setClose(Double.parseDouble(e.getAttribute("CLOSE")));
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
