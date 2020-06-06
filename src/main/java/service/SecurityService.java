package service;

import model.Security;
import repository.SecurityRepository;

import java.util.List;

public class SecurityService {

    private SecurityRepository repository;

    public SecurityService(SecurityRepository repository) {
        this.repository = repository;
    }

    public void addSecurity(List<Security> securities) {
        // mapping to db
    }

    public void addSecurity(Security sec) {
        // mapping to db
    }
}
