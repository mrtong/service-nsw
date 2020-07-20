package com.foo.servicensw.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.foo.servicensw.model.RegInfo;
import com.foo.servicensw.repo.RegistrationRepo;
import com.foo.servicensw.util.MockDataGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class RegistrationServiceTest {
    private RegistrationService registrationService;

    @Mock
    private RegistrationRepo registrationRepo;

    @Before
    public void setup(){
        registrationService = new RegistrationService(registrationRepo);
    }
    @Test
    public void shouldBeAbleToReturnAllRegistrations() throws JsonProcessingException {
        when(registrationRepo.findAll()).thenReturn(MockDataGenerator.generateRegInfo());

        final List<RegInfo> all = registrationService.findAll();

        assertNotNull(all);
        assertEquals(2, all.size());

    }
}