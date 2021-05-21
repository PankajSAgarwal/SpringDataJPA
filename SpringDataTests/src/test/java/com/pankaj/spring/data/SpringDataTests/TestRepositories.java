package com.pankaj.spring.data.SpringDataTests;

import com.pankaj.spring.data.SpringDataTests.model.ChessPlayer;
import com.pankaj.spring.data.SpringDataTests.repsoitories.ChessPlayerRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestRepositories {
    public static final Logger log = LoggerFactory.getLogger(TestRepositories.class.getName());

    @Autowired
    private ChessPlayerRepository playerRepo;

    @Test
    @Sql("/test-data.sql")
    public void testQuery(){
        log.info("...testQuery...");

        List<ChessPlayer> players=playerRepo.findByLastName("Carlsen");
        log.info("Found " + players.size() + " players");
    }

    @Test
    @Commit
    public void testTransaction(){
        log.info("...testTransaction...");

        ChessPlayer player=new ChessPlayer();
        player.setFirstName("Pankaj");
        player.setLastName("Agarwal");

        playerRepo.saveAndFlush(player);
    }

}
