package com.example.creditcardtest.repository;

import com.example.creditcardtest.entity.CreditCard;
import com.example.creditcardtest.entity.Person;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CreditCardRepositoryImplTest {

    private CreditCardRepositoryImpl creditCardRepository;
    private PersonRepositoryImpl personRepository;

    @Autowired
    CreditCardRepositoryImplTest(CreditCardRepositoryImpl creditCardRepository, PersonRepositoryImpl personRepository) {
        this.creditCardRepository = creditCardRepository;
        this.personRepository = personRepository;
    }

    @Test
    @Order(1)
    void shouldReturnStatusCreatedAndPersonSaved() {
        Person personCreated = personRepository.saveOrUpdate(
                new Person(
                        "pepito perez",
                        LocalDate.of(1996, 1, 15),
                        "20153552")
        );

        CreditCard creditCardSaved = creditCardRepository.saveOrUpdate(
                new CreditCard(
                        "0343879423",
                    2134,
                    LocalDate.of(2999, 1, 1),
                    personCreated
                )
        );

        assertThat(creditCardSaved.getId()).isNotNull();
    }

    @Test
    @Order(2)
    void shouldReturnAllCreditCards() {
        List<CreditCard> allCreditCards = creditCardRepository.getAll();
        assertThat(allCreditCards.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    @Order(3)
    void shouldReturnTrueIfCreditCardDeleted() {
        assertThat(creditCardRepository.deleteById(1L)).isTrue();
    }

    @Test
    @Order(4)
    void shouldReturnFalseIfCreditCardNotDeleted() {
        assertThat(creditCardRepository.deleteById(9L)).isFalse();
    }
}