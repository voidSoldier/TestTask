package com.javajunior.testtask.web;

import com.javajunior.testtask.service.FileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = FileDataController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class FileDataController {

    static final String REST_URL = "/rest/load";

    @Autowired
    private FileDataService service;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addFromFile(@RequestBody List<String> fileNames) {
        service.addDataFromFiles(fileNames);
    }
}
