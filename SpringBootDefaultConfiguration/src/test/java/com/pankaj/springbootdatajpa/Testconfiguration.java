package com.pankaj.springbootdatajpa;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class Testconfiguration {
    private static final Logger log = LoggerFactory.getLogger(TestConfiguration.class);

    @Test
    public void testConnection(){
        log.info("...testConnection...");

        // we will do something useful here ...
    }


}
