package com.pankaj.spring.data.demo.controller;

import com.pankaj.spring.data.demo.model.Author;
import com.pankaj.spring.data.demo.repositories.AuthorRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.persistence.NoResultException;
import java.util.Optional;

@RestController
@RequestMapping(path="author")
@Transactional
public class AuthorController {

    private AuthorRepository authorRepo;

    public AuthorController(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable("id") Long id){
        Optional<Author> a = authorRepo.findById(id);

        if(!a.isPresent())
            throw new NoResultException();

        return a.get();
    }

    @PostMapping
    public void persistAuthor(Author a){
        authorRepo.save(a);
    }


}
