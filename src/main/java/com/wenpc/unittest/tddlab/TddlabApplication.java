package com.wenpc.unittest.tddlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class TddlabApplication {

    public static void main(String[] args) {
        SpringApplication.run(TddlabApplication.class, args);
    }

}
