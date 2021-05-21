package com.pankaj.springdatajpa;

import com.pankaj.springdatajpa.model.ChessPlayer;
import com.pankaj.springdatajpa.repository.ChessPlayerCrudRepository;

import com.pankaj.springdatajpa.repository.ChessPlayerCustomRepository;
import com.pankaj.springdatajpa.repository.ChessPlayerJpaRepository;
import com.pankaj.springdatajpa.repository.ChessPlayerPagingRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Commit
public class TestRepositories {
    private static final Logger log = LoggerFactory.getLogger(TestRepositories.class);

    @Autowired
    private ChessPlayerCrudRepository playerCrudRepo;

    @Autowired
    private ChessPlayerPagingRepository playerPagingRepo;

    @Autowired
    private ChessPlayerJpaRepository playerJpaRepo;

    @Autowired
    private ChessPlayerCustomRepository playerCustomRepo;

    @Test
    @Sql("/test_data.sql")
    public void testCrudRepo(){
        log.info("...testCrudRepo()...");
        ChessPlayer player = new ChessPlayer();
        player.setFirstName("Pankaj");
        player.setLastName("Agarwal");
        playerCrudRepo.save(player);

        assertThat(playerCrudRepo.findById(player.getId())).hasValue(player);

        playerCrudRepo.findAll();
    }

    @Test
    @Sql("/test_data.sql")
    public void testPagingRepo(){
        log.info("...testPagingRepo()...");
        Pageable pageable = PageRequest.of(1,10);
        Page<ChessPlayer> players = playerPagingRepo.findAll(pageable);
        assertThat(players.getTotalElements()).isEqualTo(4);
        assertThat(players.getTotalPages()).isEqualTo(1);
    }

    @Test
    @Sql("/test_data.sql")
    public void testJpaRepo(){
        log.info("... testJpaRepo ...");
        List<ChessPlayer> players = playerJpaRepo.findAll();
        playerJpaRepo.deleteInBatch(players);
        assertThat(playerJpaRepo.findAll().size()).isEqualTo(0);
    }

    @Test
    @Sql("/test_data.sql")
    public void testCustomRepo(){
        log.info("...testCustomRepo()...");

        ChessPlayer player = new ChessPlayer();
        player.setFirstName("pankaj");
        player.setLastName("agarwal");

        playerCustomRepo.save(player);

        assertThat(playerCustomRepo.findById(player.getId())).hasValue(player);
        playerCustomRepo.findAll();
    }

    @Test
    @Sql("/test_data.sql")
    public void debugCrudRepo(){
        log.info("...debugCrudRepo()...");

        ChessPlayer player = new ChessPlayer();
        player.setFirstName("Pankaj");
        player.setLastName("Aggarwal");

        playerCrudRepo.save(player);

        player.setLastName("Agarwal"); // triggers an update sql by JPA automatically as player is a managed entity

        // saving again a managed entity like player is unnecessary
        // as any updates to a managed entity is automatically detected .

       // playerCrudRepo.save(player);

        assertThat(playerCrudRepo.findById(player.getId())).hasValue(player);
        playerCrudRepo.findAll();

    }

}
