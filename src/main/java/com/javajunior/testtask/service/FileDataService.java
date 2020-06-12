package com.javajunior.testtask.service;

import com.javajunior.testtask.SecParser;
import com.javajunior.testtask.model.History;
import com.javajunior.testtask.model.Security;
import com.javajunior.testtask.repository.HistoryRepository;
import com.javajunior.testtask.repository.SecurityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class FileDataService {

    private HistoryRepository historyRepository;
    private SecurityRepository securityRepository;


    private SecParser parser = new SecParser();

    public FileDataService(HistoryRepository historyRepository, SecurityRepository securityRepository) {
        this.historyRepository = historyRepository;
        this.securityRepository = securityRepository;
    }

    public void addDataFromFiles(MultipartFile[] files) {
        try {
            parser.parse(files);
            parser.matchHistoryToSecurity();

            if (parser.getHistoryList().isEmpty()) {
                for (Security sec : parser.getSecurityList()) {
                    securityRepository.saveAndFlush(sec);
                }
            } else {
                for (History hist : parser.getHistoryList()) {
                    historyRepository.saveAndFlush(hist);
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

    }
}
