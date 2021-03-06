package com.foo.servicensw.controller;

import com.foo.servicensw.exception.RegistrationNotFoundException;
import com.foo.servicensw.model.RegInfo;
import com.foo.servicensw.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
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

    private final RegistrationService registrationService;

    public RegistrationController(final RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping(path = "/registrations")
    public ResponseEntity<JSONObject> getAllRegistrations() {
        log.debug("In getAllRegistrations of RegistrationController.");

        final List<RegInfo> allRegistrations = registrationService.findAll();
        if (allRegistrations.isEmpty()) {
            log.warn("No Registrations were found.");
            throw new RegistrationNotFoundException("No Registrations were found.");
        }

        log.debug("Successfully found [{}] of registrations.", allRegistrations.size());

        final JSONObject jsonObject = new JSONObject();

        jsonObject.put("registrations", allRegistrations);

        return new ResponseEntity<>(jsonObject, HttpStatus.OK);
    }
}
