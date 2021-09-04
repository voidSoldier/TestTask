package com.javajunior.testtask.service;

import com.javajunior.testtask.SecParser;
import com.javajunior.testtask.repository.HistoryRepository;
import com.javajunior.testtask.repository.SecurityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

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

            if (parser.getHistoryList().isEmpty())
                parser.getSecurityList().forEach(sec -> securityRepository.saveAndFlush(sec));
            else
                parser.getHistoryList().forEach(hist -> historyRepository.saveAndFlush(hist));

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

    }
}
