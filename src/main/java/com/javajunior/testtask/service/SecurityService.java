package com.javajunior.testtask.service;

import com.javajunior.testtask.Util;
import com.javajunior.testtask.model.Security;
import com.javajunior.testtask.repository.SecurityRepository;
import com.javajunior.testtask.to.SecurityTo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
        else throw new Util.EntityNotFoundException();
    }

    public List<SecurityTo> getAll() {
        return Util.Converter.convertTo(repository.getAllWithHistory());
    }

    public List<Security> getAllFull() {
        return (repository.findAll());
    }

    public Security get(int id) throws Util.EntityNotFoundException {
        return repository.findById(id).orElseThrow(Util.EntityNotFoundException::new);
    }

    public void update(Security updated) {
        repository.save(updated);
    }

    public List<SecurityTo> filter(LocalDate tradeDate, String emitentTitle) {
        List<SecurityTo> all = getAll();
        return all.stream()
                .filter(sto -> tradeDate == null ? sto.getTradeDate() == tradeDate : true &&
                        emitentTitle == null ? sto.getEmitentTitle().equals(emitentTitle) : true)
                .collect(Collectors.toList());
    }

}
