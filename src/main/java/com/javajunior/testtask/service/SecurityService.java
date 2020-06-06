package com.javajunior.testtask.service;

import com.javajunior.testtask.EntityNotFoundException;
import com.javajunior.testtask.model.History;
import com.javajunior.testtask.model.Security;
import com.javajunior.testtask.repository.SecurityRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class SecurityService {

    private SecurityRepository repository;

    public SecurityService(SecurityRepository repository) {
        this.repository = repository;
    }

    public void addSecurity(List<Security> sec) {
        repository.saveAll(sec);
    }

    public void addSecurity(Security sec) {
        repository.save(sec);
    }

    public int deleteSecurity(int id) {
       return repository.deleteById(id);
//       repository.deleteById(id);
    }

    public List<Security> getAll(){
        return repository.findAll();
    }


    public Security getSecurity(int id) throws FileNotFoundException {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void updateSecurity(Security updated) {
        repository.save(updated);
    }

//    public void addHistory(int id, History history) {
//      repository.addHistory(id, history);;
//    }
}
