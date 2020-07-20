package com.foo.servicensw.controller;

import com.foo.servicensw.service.RegistrationService;
import com.foo.servicensw.util.MockDataGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class RegistrationControllerIT {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private RegistrationService registrationService;

    @Test
    public void shouldBeAbleToGetAllRegistrations() throws Exception {
        when(registrationService.findAll()).thenReturn(MockDataGenerator.generateRegInfo());

        final MvcResult mvcResult = mvc.perform(get("/registrations")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        final String response = mvcResult.getResponse().getContentAsString();
        final String expectedResponse="{\"registrations\":[{\"plateNumber\":\"EBF28E\",\"registration\":{\"expiry_date\":\"2021-02-05T23:15:30.000Z\",\"expired\":false},\"vehicle\":{\"type\":\"Wagon\",\"make\":\"BMW\",\"model\":\"X4 M40i\",\"colour\":\"Blue\",\"vin\":\"12389347324\",\"tareWeight\":\"1700\",\"grossMass\":null},\"insurer\":{\"name\":\"Allianz\",\"code\":32}},{\"plateNumber\":\"CXD82F\",\"registration\":{\"expiry_date\":\"2020-03-01T23:15:30.000Z\",\"expired\":true},\"vehicle\":{\"type\":\"Hatch\",\"make\":\"Toyota\",\"model\":\"Corolla\",\"colour\":\"Silver\",\"vin\":\"54646546313\",\"tareWeight\":\"1432\",\"grossMass\":\"1500\"},\"insurer\":{\"name\":\"AAMI\",\"code\":17}}]}";

        assertEquals(expectedResponse, response);
    }

    @Test
    public void shoulReturnStatus404WhenNoRegistrationsWereFound() throws Exception {
        when(registrationService.findAll()).thenReturn(new ArrayList<>());

        final MvcResult mvcResult = mvc.perform(get("/registrations")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }
}