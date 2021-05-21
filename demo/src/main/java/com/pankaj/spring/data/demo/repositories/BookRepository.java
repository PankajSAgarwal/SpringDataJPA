package com.pankaj.spring.data.demo.repositories;

import com.pankaj.spring.data.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
