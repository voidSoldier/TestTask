package com.javajunior.testtask.web;

import com.javajunior.testtask.service.FileDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.swing.*;
import java.io.IOException;

@RestController
//@RequestMapping(value = FileDataController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class FileDataController {

    static final String REST_URL = "/load";
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private FileDataService service;


//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void addFromFile(@RequestBody List<String> fileNames) {
//        service.addDataFromFiles(fileNames);
//    }
// , headers = "Content-Type=multipart/form-data"
    @PostMapping("/load")
    public ModelAndView uploadSecurity(@RequestParam("file") MultipartFile[] files) throws IOException {
        log.info("_____uploading files      ----->loadSecurity");

        service.addDataFromFiles(files);
        log.info("_____redirecting to /load");
        return new ModelAndView("/load");

    }

    @PostMapping("/loadHistory")
    public ModelAndView uploadHistory(@RequestParam("file") MultipartFile[] files) throws IOException {
        log.info("_____uploading files       ----->loadHistory");

        service.addDataFromFiles(files);
        log.info("_____redirecting to /load");
        return new ModelAndView("/load");

    }
}
