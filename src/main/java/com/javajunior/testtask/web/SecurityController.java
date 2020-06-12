package com.javajunior.testtask.web;

import com.javajunior.testtask.Util;
import com.javajunior.testtask.model.Security;
import com.javajunior.testtask.service.SecurityService;
import com.javajunior.testtask.to.SecurityTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = SecurityController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class SecurityController {

    static final String REST_URL = "/securities";
    protected final Logger log = LoggerFactory.getLogger(getClass());


    @Autowired
    private SecurityService service;


    //    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    public void add(Security security) {
//        log.info("adding new security: {}", security.getName());
//        Util.Validator.checkName(security);
//        service.add(security);
//    }
//
    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView saveOrUpdate(Security security) {
        log.info("_____new security: {}", security.getName());
        Util.Validator.checkName(security);
        service.saveOrUpdate(security);
        return new ModelAndView("index");
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ModelAndView delete(@PathVariable int id) {
        log.info("deleting security with id {}", id);
        service.delete(id);
        return new ModelAndView("index");
    }


    @GetMapping("/with-history")
    public ResponseEntity<List<SecurityTo>> getAllWithHistory() {
        log.info("getting all securities with history");
        try {
            return new ResponseEntity<>(service.getAllWithHistory(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Security>> getAll() {
        log.info("getting all securities");
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public Security get(@PathVariable int id) {
        log.info("getting security with id {}", id);
        return service.get(id);
    }

    @GetMapping(value = "/filter")
    public ResponseEntity<List<SecurityTo>> filter(@RequestParam @Nullable String tradeDate, @RequestParam @Nullable String emitentTitle) {
        log.info("filtering securities");
//        return service.filter(tradeDate, emitentTitle);
        LocalDate ld = tradeDate == null || tradeDate.isEmpty() ? null : LocalDate.parse(tradeDate);
        try {
            return new ResponseEntity<>(service.filter(ld, emitentTitle), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
//    @PutMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void update(@RequestBody Security updated) {
//        log.info("updating security {}", updated);
//        Util.Validator.checkName(updated);
//        service.update(updated);
//    }

    }
