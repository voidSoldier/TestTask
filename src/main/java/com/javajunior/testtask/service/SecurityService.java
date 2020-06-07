package com.javajunior.testtask.service;

import com.javajunior.testtask.EntityNotFoundException;
import com.javajunior.testtask.SecParser;
import com.javajunior.testtask.model.History;
import com.javajunior.testtask.model.Security;
import com.javajunior.testtask.repository.SecurityRepository;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class SecurityService {

    private SecurityRepository repository;

    public SecurityService(SecurityRepository repository) {
        this.repository = repository;
    }



    public void add(Security security) {
        repository.save(security);
    }

    public boolean delete(int id) {
        int result = repository.deleteById(id);
        if (result != 0) return true;
        else throw new EntityNotFoundException();
    }

    public List<Security> getAll(){
        return repository.findAll();
    }


    public Security get(int id) throws EntityNotFoundException {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void update(Security updated) {
        repository.save(updated);
    }

}
