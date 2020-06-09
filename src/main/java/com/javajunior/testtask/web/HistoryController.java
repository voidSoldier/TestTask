package com.javajunior.testtask.web;

import com.javajunior.testtask.model.History;
import com.javajunior.testtask.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = HistoryController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class HistoryController {

    static final String REST_URL = "/histories";

    @Autowired
    private HistoryService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody History history) {
        service.add(history);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping
    public List<History> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public History get(@PathVariable int id) {
        return service.get(id);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody History updated) {
        service.update(updated);
    }

}
