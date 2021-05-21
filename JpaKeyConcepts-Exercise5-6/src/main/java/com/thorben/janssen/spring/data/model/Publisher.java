package com.thorben.janssen.spring.data.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
public class Publisher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_sequence")
    @SequenceGenerator(name = "publisher_sequence", sequenceName = "publisher_sequence")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books = new HashSet<>();

    @Version
    private int version;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
