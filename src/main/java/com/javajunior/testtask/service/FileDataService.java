package com.javajunior.testtask.service;

import com.javajunior.testtask.SecParser;
import com.javajunior.testtask.model.History;
import com.javajunior.testtask.model.Security;
import com.javajunior.testtask.repository.HistoryRepository;
import com.javajunior.testtask.repository.SecurityRepository;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class FileDataService {

    private HistoryRepository historyRepository;
    private SecurityRepository securityRepository;

    public FileDataService(HistoryRepository historyRepository, SecurityRepository securityRepository) {
        this.historyRepository = historyRepository;
        this.securityRepository = securityRepository;
    }

    public void addDataFromFiles(List<String> fileNames)  {

       try {
           SecParser parser = new SecParser();
           Map<List<Security>, List<History>> result = parser.parse(fileNames);

           securityRepository.saveAll(result.keySet().iterator().next());
           historyRepository.saveAll(result.values().iterator().next());

       } catch (ParserConfigurationException | IOException | SAXException e) {
           e.printStackTrace();
       }

    }
}
