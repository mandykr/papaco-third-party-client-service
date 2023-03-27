package com.papaco.papacothirdpartyclientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PapacoThirdPartyClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PapacoThirdPartyClientServiceApplication.class, args);
    }

}
