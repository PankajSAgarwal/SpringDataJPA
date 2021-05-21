package com.pankaj.springdatajpa.SpringDataTestcontainers;

import com.pankaj.springdatajpa.SpringDataTestcontainers.controller.ChessPlayerController;
import com.pankaj.springdatajpa.SpringDataTestcontainers.model.ChessPlayer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
@Commit
public class TestApplication {

    private static final Logger log = LoggerFactory.getLogger(TestApplication.class);

    @Container
    public static PostgreSQLContainer postgreSQLContainer=
            new PostgreSQLContainer("postgres:11")
                .withDatabaseName("springDataJpaCourse")
                .withPassword("postgres")
                .withUsername("postgres");


    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url",postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.password",postgreSQLContainer::getPassword);
        registry.add("spring.datasource.username",postgreSQLContainer::getUsername);
    }

    @Autowired
    private ChessPlayerController playerController;

    @Test
    public void testController(){
        log.info("...testController()...");

        ChessPlayer player = new ChessPlayer();
        player.setFirstName("pankaj");
        player.setLastName("agarwal");

        playerController.persistPlayer(player);


    }



}
