package com.pankaj.springdatajpa.SpringDataJpaSorting;

import com.pankaj.springdatajpa.SpringDataJpaSorting.repository.ChessPlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Commit
public class TestSorting {
    private static final Logger log = LoggerFactory.getLogger(TestSorting.class);

    @Autowired
    private ChessPlayerRepository playerRepo;


}
