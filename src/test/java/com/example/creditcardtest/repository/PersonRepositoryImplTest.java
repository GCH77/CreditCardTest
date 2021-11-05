package com.example.creditcardtest.repository;

import com.example.creditcardtest.entity.Person;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonRepositoryImplTest {

    private PersonRepositoryImpl personRepository;

    @Autowired
    PersonRepositoryImplTest(PersonRepositoryImpl personRepository) {
        this.personRepository = personRepository;
    }

    @Test
    @Order(1)
    void shouldReturnSavedPerson() {
        Person personCreated = personRepository.saveOrUpdate(
                new Person(
                        "pepito perez",
                        LocalDate.of(1996, 1, 15),
                        "20153552")
        );
        assertThat(personCreated.getId()).isNotNull();
    }

    @Test
    @Order(2)
    void shouldReturnAllPersons() {
        List<Person> allPerson = personRepository.getAll();
        assertThat(allPerson.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    @Order(3)
    void shouldReturnTrueByDeletedPerson() {
        assertThat(personRepository.deleteById(1L)).isTrue();
    }

    @Test
    @Order(4)
    void shouldReturnFalseByNoneDeletedPerson() {
        assertThat(personRepository.deleteById(9L)).isFalse();
    }
}