package com.javajunior.testtask.web;

import com.javajunior.testtask.service.FileDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
public class FileDataController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private FileDataService service;

    @PostMapping("/load")
    public ModelAndView uploadSecurity(@RequestParam("file") MultipartFile[] files) throws IOException {
        log.info("_____uploading files      ----->loadSecurity");
        service.addDataFromFiles(files);
        return new ModelAndView("/load");
    }

    @PostMapping("/loadHistory")
    public ModelAndView uploadHistory(@RequestParam("file") MultipartFile[] files) throws IOException {
        log.info("_____uploading files       ----->loadHistory");
        service.addDataFromFiles(files);
        return new ModelAndView("/load");
    }
}
