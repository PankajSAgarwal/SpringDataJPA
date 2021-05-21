package com.thorben.janssen.spring.data.repository;

import java.util.List;

import com.thorben.janssen.spring.data.model.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
    @Query("select a from Author a WHERE a.firstName = :firstName AND a.lastName = :lastName")
    List<Author> selectByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT a from Author a JOIN a.books b where b.title = :title")
    List<Author> selectAuthorsOfBook(String title);
}
