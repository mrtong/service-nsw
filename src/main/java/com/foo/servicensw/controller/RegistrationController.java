package com.foo.servicensw.controller;

import com.foo.servicensw.model.Registration;
import com.foo.servicensw.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(final RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping(path = "/registrations")
    public ResponseEntity<List<Registration>> getAllAccounts() {
        final  List<Registration> allRegistrations = registrationService.findAll();

        return new ResponseEntity<>(allRegistrations, HttpStatus.OK);
    }
}
