package com.javajunior.testtask.web;

import com.javajunior.testtask.model.History;
import com.javajunior.testtask.service.HistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping(value = "/histories", produces = MediaType.APPLICATION_JSON_VALUE)
public class HistoryController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private HistoryService service;

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView saveOrUpdate(History history) {
        log.info("_____new history: {}", history.getSecid());
        service.saveOrUpdate(history);
        return new ModelAndView("index");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ModelAndView delete(@PathVariable int id) {
        log.info("deleting history with id {}", id);
        service.delete(id);
        return new ModelAndView("index");
    }

    @GetMapping
    public ResponseEntity<List<History>> getAll() {
        log.info("getting all history");
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public History get(@PathVariable int id) {
        log.info("getting history with id {}", id);
        return service.get(id);
    }
}
