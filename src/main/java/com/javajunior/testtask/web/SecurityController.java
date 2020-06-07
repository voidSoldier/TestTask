package com.javajunior.testtask.web;

import com.javajunior.testtask.Util;
import com.javajunior.testtask.model.Security;
import com.javajunior.testtask.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = SecurityController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class SecurityController {

    static final String REST_URL = "/rest/securities";

    @Autowired
    private SecurityService service;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody Security security) {
        Util.Validator.checkName(security);
        service.add(security);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }


    @GetMapping
    public List<Security> getAll() {
        return service.getAll();
    }


    @GetMapping("/{id}")
    public Security get(@PathVariable int id) {
        return service.get(id);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Security updated) {
        service.update(updated);
    }



//    private void checkName(Security security) {
//        char[] legalSigns = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя 0123456789".toCharArray();
//        char[] name = security.getName().toLowerCase().toCharArray();
//
//        for (char c: name) {
//            for (char legal : legalSigns) {
//                if (c != legal) throw new Util.IllegalSecurityNameException();
//            }
//        }
//    }
}
