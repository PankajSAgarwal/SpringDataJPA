package com.thorben.janssen.spring.data;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import com.thorben.janssen.spring.data.model.Author;
import com.thorben.janssen.spring.data.repository.AuthorRepository;

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
public class TestKeyConcepts {

    private static final Logger log = LoggerFactory.getLogger(TestKeyConcepts.class);

    @Autowired
    private AuthorRepository authorRepo;

    @Test
    public void testSelectByFirstNameAndLastName() {
        log.info("... testSelectByFirstNameAndLastName ...");

        List<Author> authors = new ArrayList<>();
        authors = authorRepo.selectByFirstNameAndLastName("Thorben", "Janssen");
        assertThat(authors.size()).isEqualTo(1);
        assertThat(authors.get(0).getFirstName()).isEqualTo("Thorben");
        assertThat(authors.get(0).getLastName()).isEqualTo("Janssen");
    }

    @Test
    public void testSelectAuthorsOfBook() {
        log.info("... testSelectAuthorsOfBook ...");

        List<Author> authors = new ArrayList<>();
        authors = authorRepo.selectAuthorsOfBook("Hibernate Tips - More than 70 solutions to common Hibernate problems");
        
        assertThat(authors.size()).isEqualTo(2);
        assertThat(authors.get(0).getLastName()).isIn("Janssen", "Ebersole");
        assertThat(authors.get(1).getLastName()).isIn("Janssen", "Ebersole");
    }
}
