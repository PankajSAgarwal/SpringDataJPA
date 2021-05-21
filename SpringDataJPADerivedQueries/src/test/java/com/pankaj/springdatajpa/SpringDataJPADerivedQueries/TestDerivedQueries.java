package com.pankaj.springdatajpa.SpringDataJPADerivedQueries;

import com.pankaj.springdatajpa.SpringDataJPADerivedQueries.model.ChessPlayer;
import com.pankaj.springdatajpa.SpringDataJPADerivedQueries.repository.ChessPlayerRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Commit
public class TestDerivedQueries {

    private static final Logger log = LoggerFactory.getLogger(TestDerivedQueries.class);

    @Autowired
    private ChessPlayerRepository playerRepo;

    @Test
    public void testFindByLastName() {
        log.info("... testFindByLastName ...");

        List<ChessPlayer> players = playerRepo.findByLastName("Carlsen");
        assertThat(players.size()).isEqualTo(1);

        ChessPlayer player = players.get(0);
        log.info(player.getFirstName() + " " + player.getLastName());
    }

    @Test
    public void testFindByFirstNameAndLastName(){
        log.info("...testFindByFirstNameAndLastName...");
        List<ChessPlayer> players = playerRepo.findByFirstNameAndLastName("Magnus","Carlsen");
        assertThat(players.size()).isEqualTo(1);

        ChessPlayer player = players.get(0);
        log.info(player.getFirstName()+ " " + player.getLastName());

    }

    @Test
    public void testExistsByLastName(){
        log.info("...testExistsByLastName...");

        boolean exists = playerRepo.existsByLastName("Carlsen");
        assertThat(exists).isTrue();
        log.info("There is atleast one player with name Carlsen");
    }

    @Test
    public void testCountByLastName(){
        log.info("...countByLastName...");

        Long numOfPlayers = playerRepo.countByLastName("Doe");
        assertThat(numOfPlayers).isEqualTo(15);

        log.info("There are " + numOfPlayers + "with the last name Doe");
    }

    @Test
    public void testFindBFirst10ByLastName(){
        log.info("...testFindBFirst10ByLastName...");
        List<ChessPlayer> players = playerRepo.findFirst10ByLastName("Doe");
        assertThat(players.size()).isEqualTo(10);

        log.info("The query returned " + players.size() + " players with the last name " +players.get(0).getLastName());
    }

    @Test
    public void testFindByLastNameLike(){
        log.info("...testFindByLastNameLike...");
        List<ChessPlayer> players = playerRepo.findByLastNameLike("Carl%");
        assertThat(players.size()).isEqualTo(1);
        ChessPlayer chessPlayer = players.get(0);
        log.info(chessPlayer.getFirstName() + " " + chessPlayer.getLastName());
    }

    @Test
    public void testFindByLastNameContainingIgnoreCase(){
        log.info("...testFindByLastNameContainingIgnoreCase...");

        List<ChessPlayer> players = playerRepo.findByLastNameContainingIgnoreCase("arl");
        assertThat(players.size()).isEqualTo(1);

        ChessPlayer player = players.get(0);
        log.info(player.getFirstName() + " " + player.getLastName());
    }

    @Test
    public void testFindByLastNameContainingIgnoreCaseAndFirstName(){
        log.info("...testFindByLastNameContainingIgnoreCaseAndFirstName...");

        List<ChessPlayer> players = playerRepo.findByLastNameContainingIgnoreCaseAndFirstName("arl", "Magnus");
        assertThat(players.size()).isEqualTo(1);

        ChessPlayer player = players.get(0);

        log.info(player.getFirstName() + " " + player.getLastName());
    }

    @Test
    public void testFindByLastNameNotOrderByLastNameAsFirstNameAsc(){
        log.info("...testFindByLastNameNotOrderByLastNameAsFirstNameAsc...");
        List<ChessPlayer> players = playerRepo.findByLastNameNotOrderByLastNameAscFirstNameAsc("Doe");
        assertThat(players.size()).isEqualTo(4);

        for (ChessPlayer player : players) {
            log.info(player.getFirstName() + " " + player.getLastName());
        }
    }

    @Test
    public void testFindByTournamentName(){
        log.info("...testFindByTournamentName...");

        List<ChessPlayer> players = playerRepo.findByTournamentsName("Tata Steel Chess Tournament 2021");
        assertThat(players.size()).isEqualTo(4);

        for (ChessPlayer player : players) {
            log.info(player.getFirstName()+ " " + player.getLastName());
        }
    }





}
