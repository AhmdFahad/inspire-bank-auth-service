package com.inspire.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    @Value("${spring.profiles.active}")
    private String activeProfile;
    @Value("${eureka.client.serviceUrl.defaultZone}")
    private String serviceUrl;

    @Override
    public void run(String... args) throws Exception {
        log.info("Active Profile");
        log.info(activeProfile);
        log.info("euruka:"+serviceUrl);
    }
}
