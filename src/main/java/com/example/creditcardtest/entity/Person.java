package com.example.creditcardtest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persons")
@Builder @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private LocalDate birthDate;
    private String phoneNumber;

    @OneToMany(mappedBy = "person")
    @JsonIgnoreProperties({"person"})
    private List<CreditCard> creditCards;

    public Person(Long id, String fullName, LocalDate birthDate, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public Person(String fullName, LocalDate birthDate, String phoneNumber) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }
}
