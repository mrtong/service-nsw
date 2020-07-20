package com.foo.servicensw.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foo.servicensw.model.RegInfo;

import java.util.Arrays;
import java.util.List;

public class MockDataGenerator {

    private MockDataGenerator() {
    }

    public static List<RegInfo> generateRegInfo() throws JsonProcessingException {
        final ObjectMapper om = new ObjectMapper();
        final String response1 = "{\n" +
                "            \"plateNumber\": \"EBF28E\",\n" +
                "            \"registration\": {\n" +
                "                \"expiry_date\": \"2021-02-05T23:15:30.000Z\",\n" +
                "                \"expired\": false\n" +
                "            },\n" +
                "            \"vehicle\": {\n" +
                "                \"type\": \"Wagon\",\n" +
                "                \"make\": \"BMW\",\n" +
                "                \"model\": \"X4 M40i\",\n" +
                "                \"colour\": \"Blue\",\n" +
                "                \"vin\": \"12389347324\",\n" +
                "                \"tareWeight\": \"1700\",\n" +
                "                \"grossMass\": null\n" +
                "            },\n" +
                "            \"insurer\": {\n" +
                "                \"name\": \"Allianz\",\n" +
                "                \"code\": 32\n" +
                "            }\n" +
                "        }";

        final RegInfo regInfo1 = om.readValue(response1, RegInfo.class);

        final String response2 = " {\n" +
                "            \"plateNumber\": \"CXD82F\",\n" +
                "            \"registration\": {\n" +
                "                \"expiry_date\": \"2020-03-01T23:15:30.000Z\",\n" +
                "                \"expired\": true\n" +
                "            },\n" +
                "            \"vehicle\": {\n" +
                "                \"type\": \"Hatch\",\n" +
                "                \"make\": \"Toyota\",\n" +
                "                \"model\": \"Corolla\",\n" +
                "                \"colour\": \"Silver\",\n" +
                "                \"vin\": \"54646546313\",\n" +
                "                \"tareWeight\": \"1432\",\n" +
                "                \"grossMass\": \"1500\"\n" +
                "            },\n" +
                "            \"insurer\": {\n" +
                "                \"name\": \"AAMI\",\n" +
                "                \"code\": 17\n" +
                "            }\n" +
                "        }";
        final RegInfo regInfo2 = om.readValue(response2, RegInfo.class);

        return Arrays.asList(regInfo1,regInfo2);
    }
}
