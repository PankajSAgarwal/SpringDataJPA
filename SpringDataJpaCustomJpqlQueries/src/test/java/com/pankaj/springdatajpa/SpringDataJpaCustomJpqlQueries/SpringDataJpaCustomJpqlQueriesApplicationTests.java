package com.pankaj.springdatajpa.SpringDataJpaCustomJpqlQueries;

import com.pankaj.springdatajpa.SpringDataJpaCustomJpqlQueries.model.ChessPlayer;
import com.pankaj.springdatajpa.SpringDataJpaCustomJpqlQueries.repository.ChessPlayerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Commit
class SpringDataJpaCustomJpqlQueriesApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(SpringDataJpaCustomJpqlQueriesApplicationTests.class);
	@Autowired
	private ChessPlayerRepository playerRepo;

	@Test
	public void testFindByName(){
		log.info("...testFindByName...");
		List<ChessPlayer> players = playerRepo.findByName("%arl%", "Magnus");
		assertThat(players.size()).isEqualTo(1);
		ChessPlayer player = players.get(0);
		log.info(player.getFirstName() + " " + player.getLastName());
	}

	@Test
	public void testFindByNameWithoutSelect(){

		log.info("...testFindByNameWithoutSelect...");

		List<ChessPlayer> players = playerRepo.findByNameWithoutSelect("%arl%", "Magnus");
		assertThat(players.size()).isEqualTo(1);

		ChessPlayer player = players.get(0);
		log.info(player.getFirstName() + " " + player.getLastName());
	}

	@Test
	public void testFindByNameAndTournamentOrdered(){
		log.info("...testFindByNameAndTournamentOrdered...");
		List<ChessPlayer> players = playerRepo.
				findByNameAndTournamentOrderedByPlayerName("%a%",
						"%a%",
						"Tata Steel Chess Tournament 2021");

		assertThat(players.size()).isEqualTo(2);
		for (ChessPlayer player : players) {
			log.info(player.getFirstName() + " " + player.getLastName());
		}
	}

	@Test
	public void testFindByNameAndChessTournamentsOrderedAdvancedLike(){
		log.info("...testFindByNameAndChessTournamentsOrderedAdvancedLike...");

		List<ChessPlayer> players = playerRepo.findByNameAndChessTournamentsOrderedAdvancedLike("a", "a");
		assertThat(players.size()).isEqualTo(2);

		for (ChessPlayer player : players) {
			log.info(player.getFirstName() + " " + player.getLastName());
		}
	}




}
