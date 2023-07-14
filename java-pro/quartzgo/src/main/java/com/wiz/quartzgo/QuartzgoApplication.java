package com.wiz.quartzgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class QuartzgoApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzgoApplication.class, args);
    }

}
