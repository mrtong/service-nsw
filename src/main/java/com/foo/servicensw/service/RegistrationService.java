package com.foo.servicensw.service;

import com.foo.servicensw.model.Registration;
import com.foo.servicensw.repo.RegistrationRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RegistrationService {
    private RegistrationRepo registrationRepo;

    public RegistrationService(final RegistrationRepo registrationRepo) {
        this.registrationRepo = registrationRepo;
    }

    public List<Registration> findAll() {
        final List<Registration> allRegistrations = registrationRepo.findAll();
        return allRegistrations;
    }
}
