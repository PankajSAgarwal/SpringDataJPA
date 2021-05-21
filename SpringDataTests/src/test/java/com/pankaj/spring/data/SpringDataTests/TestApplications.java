package com.pankaj.spring.data.SpringDataTests;

import com.pankaj.spring.data.SpringDataTests.controller.ChessPlayerController;
import com.pankaj.spring.data.SpringDataTests.model.ChessPlayer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestApplications {
    private static final Logger log = LoggerFactory.getLogger(TestApplications.class.getName());

    @Autowired
    private ChessPlayerController playerController;

    @Test
    public void testController(){
        log.info("...testController...");

        ChessPlayer player = new ChessPlayer();
        player.setFirstName("Pankaj");
        player.setLastName("Agarwal");

        playerController.persistPlayer(player);
    }

}


