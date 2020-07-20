package com.foo.servicensw.service;

import com.foo.servicensw.model.RegInfo;
import com.foo.servicensw.repo.RegistrationRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RegistrationService {
    private final RegistrationRepo registrationRepo;

    public RegistrationService(final RegistrationRepo registrationRepo) {
        this.registrationRepo = registrationRepo;
    }

    @CachePut(cacheNames = "find_All_Registrations")
    public List<RegInfo> findAll() {
        log.debug("In findAll(...) of RegistrationService Now.");

        final List<RegInfo> allRegistrations = registrationRepo.findAll();

        log.debug("Complete findAll(...) calling.");

        return allRegistrations;
    }
}
