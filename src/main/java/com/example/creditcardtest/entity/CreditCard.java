package com.example.creditcardtest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "creditCards")
@Builder @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    private Integer securityCode;
    private LocalDate expirationDate;

    @ManyToOne
    @JoinColumn(name = "fk_person_id")
    @JsonIgnoreProperties("creditCards")
    private Person person;

    public CreditCard(String cardNumber, Integer securityCode, LocalDate expirationDate, Person person) {
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
        this.person = person;
    }
}
