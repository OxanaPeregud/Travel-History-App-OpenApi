package com.peregud.travelhistoryrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.peregud.travelhistoryrest.domain")
@EnableJpaRepositories("com.peregud.travelhistoryrest.repository")
public class TravelHistoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelHistoryApplication.class, args);
    }

}
