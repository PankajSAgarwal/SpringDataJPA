package com.pankaj.springjpa.data.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ChessPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
    @SequenceGenerator(name = "player_seq", sequenceName = "player_sequence", initialValue = 100, allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @Version
    private int version;

    public Long getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
