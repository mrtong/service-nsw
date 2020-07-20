package com.foo.servicensw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCaching
@EnableCircuitBreaker
public class SvcVehicleRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SvcVehicleRegistrationApplication.class, args);
    }

}
