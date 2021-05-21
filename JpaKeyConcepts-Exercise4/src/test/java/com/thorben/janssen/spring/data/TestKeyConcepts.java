package com.thorben.janssen.spring.data;

import com.thorben.janssen.spring.data.model.Author;
import com.thorben.janssen.spring.data.model.Book;
import com.thorben.janssen.spring.data.model.Publisher;
import com.thorben.janssen.spring.data.repository.AuthorRepository;
import com.thorben.janssen.spring.data.repository.BookRepository;
import com.thorben.janssen.spring.data.repository.PublisherRepository;

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

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private PublisherRepository publisherRepo;

    @Test
    public void testPersist() {
        log.info("... testPersist ...");

        Author a = new Author();
        a.setFirstName("Thorben");
        a.setLastName("Janssen");
        authorRepo.save(a);

        Publisher p = new Publisher();
        p.setName("Thorben Janssen");
        publisherRepo.save(p);

        Book b = new Book();
        b.setTitle("Hibernate Tips - More than 70 solutions to common Hibernate problems");
        a.getBooks().add(b);
        b.getAuthors().add(a);
        p.getBooks().add(b);
        b.setPublisher(p);
        bookRepo.save(b);
    }
}
