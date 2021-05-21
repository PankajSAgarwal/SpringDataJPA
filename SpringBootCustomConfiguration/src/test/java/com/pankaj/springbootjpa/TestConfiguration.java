package com.pankaj.springbootjpa;

import com.pankaj.springbootjpa.model.ChessPlayer;
import com.pankaj.springbootjpa.repository.ChessPlayerRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Commit
public class TestConfiguration {
    private static final Logger log = LoggerFactory.getLogger(TestConfiguration.class);

    @Autowired
    private ChessPlayerRepository playerRepo;

    @Test
    public void testPersists(){
        log.info("...testPersists()...");
        ChessPlayer player = new ChessPlayer();
        player.setFirstName("Pankaj");
        player.setLastName("Agarwal");
        playerRepo.save(player);
        assertThat(playerRepo.findById(player.getId())).hasValue(player);
    }
}
