package com.javajunior.testtask.service;

import com.javajunior.testtask.Util;
import com.javajunior.testtask.model.History;
import com.javajunior.testtask.model.Security;
import com.javajunior.testtask.repository.HistoryRepository;
import com.javajunior.testtask.repository.SecurityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    private HistoryRepository repository;
    private SecurityRepository securityRepository;

    public HistoryService(HistoryRepository repository, SecurityRepository securityRepository) {
        this.repository = repository;
        this.securityRepository = securityRepository;
    }

    public void saveOrUpdate(History hist) {
        Security sec = securityRepository.findSecurityBySecid(hist.getSecid());
        hist.setSecurity(sec);
         repository.save(hist);
    }

    public void delete(int id) {
        if (repository.delete(id) == 0) throw new Util.EntityNotFoundException();
    }

    public List<History> getAll(){
        return repository.findAll();
    }


    public History get(int id) throws Util.EntityNotFoundException {
        return repository.findById(id).orElseThrow(Util.EntityNotFoundException::new);
    }

}
