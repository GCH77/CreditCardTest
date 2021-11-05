package com.example.creditcardtest.service;

import com.example.creditcardtest.entity.Person;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonServiceImpl personServiceImpl;

    private Person personOne;
    private Person personTwo;
    private List<Person> personList;

    @BeforeEach
    void setUp() {
        personOne = new Person(1L, "pepito", LocalDate.of(2001, 6, 23), "3201682345");
        personTwo = new Person(2L, "carlos", LocalDate.of(1999, 3, 14), "9876854561");
        personList = List.of(personOne, personTwo);
    }

    @AfterEach
    public void tearDown() {
        personOne = null;
        personTwo = null;
        personList = null;
    }

    @Test
    void shouldReturnAllPersonRegistered() {
        when(personService.getAll()).thenReturn(personList);

        List<Person> result = personServiceImpl.getAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).isEqualTo(personList);
        assertThat(result.size()).isEqualTo(personList.size());
        verify(personService, times(1)).getAll();
    }

    @Test
    void shouldReturnPersonSaved() {
        when(personService.saveOrUpdate(any(Person.class))).thenReturn(personOne);

        Person result = personServiceImpl.save(personOne);

        assertThat(result.getId()).isNotNull();
        verify(personService, times(1)).saveOrUpdate(any(Person.class));
    }

    @Test
    void shouldReturnTrueIfPersonDeleted() {
        when(personService.deleteById(personOne.getId())).thenReturn(true);

        assertThat(personServiceImpl.deleteById(personOne.getId())).isTrue();
        verify(personService, times(1)).deleteById(anyLong());
    }
}