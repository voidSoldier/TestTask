package com.javajunior.testtask.web;

import com.javajunior.testtask.Util;
import com.javajunior.testtask.model.Security;
import com.javajunior.testtask.service.SecurityService;
import com.javajunior.testtask.to.SecurityTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = SecurityController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class SecurityController {

    static final String REST_URL = "/securities";
    protected final Logger log = LoggerFactory.getLogger(getClass());


    @Autowired
    private SecurityService service;


    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void add(Security security) {
        log.info("adding new security: {}", security.getName());
        Util.Validator.checkName(security);
        service.add(security);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("deleting security with id {}", id);
        service.delete(id);
    }


    @GetMapping
    public List<SecurityTo> getAll() {
        log.info("getting all securities");
        return service.getAll();
    }


    @GetMapping("/{id}")
    public Security get(@PathVariable int id) {
        log.info("getting security with id {}", id);
        return service.get(id);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Security updated) {
        log.info("updating security {}", updated.getName());
        Util.Validator.checkName(updated);
        service.update(updated);
    }

}
