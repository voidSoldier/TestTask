package com.javajunior.testtask.service;

import com.javajunior.testtask.SecParser;
import com.javajunior.testtask.model.History;
import com.javajunior.testtask.model.Security;
import com.javajunior.testtask.repository.HistoryRepository;
import com.javajunior.testtask.repository.SecurityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class FileDataService {

    private HistoryRepository historyRepository;
    private SecurityRepository securityRepository;
    @Autowired
    private HistoryService historyService;

    private SecParser parser = new SecParser();
    protected final Logger log = LoggerFactory.getLogger(getClass());

    public FileDataService(HistoryRepository historyRepository, SecurityRepository securityRepository) {
        this.historyRepository = historyRepository;
        this.securityRepository = securityRepository;
    }


    public void addDataFromFiles(InputStream is) {

        try {
            SecParser parser = new SecParser();
            Map<List<Security>, List<History>> result = parser.parse(is);

            Set<List<Security>> resultSet = result.keySet();
            Collection<List<History>> resultCol = result.values();

            if (!resultSet.isEmpty()) securityRepository.saveAll(resultSet.iterator().next());
            if (!resultCol.isEmpty()) historyRepository.saveAll(resultCol.iterator().next());


        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

    }

    //    @Transactional
    public void addDataFromFiles(MultipartFile[] files) {
        log.info("in ---addDataFromFiles--- method");
        try {
            log.info("try ---parsing files--- ");
            parser.parse(files);
            log.info("try ---matchHistoryToSecurity--- ");
            Map<List<Security>, List<History>> result = parser.matchHistoryToSecurity();

//            Set<List<Security>> resultSet = result.keySet();
//            Collection<List<History>> resultCol = result.values();


//            securityRepository.saveAll(resultSet.iterator().next());

//            if (!resultCol.isEmpty()) historyRepository.saveAll(resultCol.iterator().next());
//            log.info("mapping ---securities--- ");
//            if (!resultSet.isEmpty()) {
//                List<Security> res = resultSet.iterator().next();
//                for (Security sec : res) {
//                    securityRepository.saveAndFlush(sec);
//                }
//            }
            if (parser.getHistoryList().isEmpty()) {
                log.info("mapping ---securities--- ");
//                List<Security> res = resultSet.iterator().next();
                for (Security sec : parser.getSecurityList()) {
                    securityRepository.saveAndFlush(sec);
                }
            } else {
                log.info("mapping ---histories--- ");
//                List<History> res = resultCol.iterator().next();
                for (History hist : parser.getHistoryList()) {
                    historyRepository.saveAndFlush(hist);
                }
            }

//            if (!resultCol.isEmpty()) {
//                log.info("mapping ---securities--- ");
//                List<Security> res = resultSet.iterator().next();
//                for (Security sec : res) {
//                    securityRepository.saveAndFlush(sec);
//                }
//            } else {
//                log.info("mapping ---histories--- ");
//                List<History> res = resultCol.iterator().next();
//                for (History hist : res) {
//                    historyRepository.saveAndFlush(hist);
//                }
//            }

//            log.info("mapping ---histories--- ");
//            if (!resultCol.isEmpty()) {
//                List<History> res = resultCol.iterator().next();
//                for (History hist : res) {
//                    historyRepository.saveAndFlush(hist);
//                }
//                historyRepository.saveAll(resultCol.iterator().next());
//            }


        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

    }
}
