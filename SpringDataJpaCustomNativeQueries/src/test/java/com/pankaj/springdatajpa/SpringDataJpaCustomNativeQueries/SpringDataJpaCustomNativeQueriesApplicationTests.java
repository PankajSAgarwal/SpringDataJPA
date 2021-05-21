package com.pankaj.springdatajpa.SpringDataJpaCustomNativeQueries;

import com.pankaj.springdatajpa.SpringDataJpaCustomNativeQueries.model.ChessPlayer;
import com.pankaj.springdatajpa.SpringDataJpaCustomNativeQueries.repository.ChessPlayerRepository;
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
class SpringDataJpaCustomNativeQueriesApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(SpringDataJpaCustomNativeQueriesApplicationTests.class);

	@Autowired
	private ChessPlayerRepository playerRepo;

	@Test
	public void testFindByNameAndTournamentOrderedAdvancedLike(){

		log.info("...testFindByNameAndTournamentOrderedAdvancedLike...");
		List<ChessPlayer> players = playerRepo.findByNameAndTournamentOrderedAdvancedLike("a",
				"a",
				"Tata Steel Chess Tournament 2021");

		assertThat(players.size()).isEqualTo(2);
		for (ChessPlayer player : players) {
			log.info(player.getFirstName() + " " + player.getLastName());
		}
	}



}
