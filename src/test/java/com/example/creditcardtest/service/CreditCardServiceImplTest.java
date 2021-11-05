package com.example.creditcardtest.service;

import com.example.creditcardtest.entity.CreditCard;
import com.example.creditcardtest.entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreditCardServiceImplTest {

    @Mock
    private CreditCardService creditCardService;

    @InjectMocks
    private CreditCardServiceImpl creditCardServiceImpl;

    private CreditCard creditCardOne;
    private CreditCard creditCardTwo;
    private List<CreditCard> creditCardList;

    @BeforeEach
    void setUp() {
        Person personOne = new Person(1L, "pepito", LocalDate.of(2001, 6, 23), "3201682345");

        creditCardOne = new CreditCard(1L, "0343879423",2134, LocalDate.of(2999, 1, 1), personOne);
        creditCardTwo = new CreditCard(2L, "1111111111",8502, LocalDate.of(2450, 1, 1), personOne);

        creditCardList = List.of(creditCardOne, creditCardTwo);
    }

    @AfterEach
    void tearDown() {
        creditCardOne = null;
        creditCardTwo = null;
        creditCardList = null;
    }

    @Test
    void shouldReturnAllCreditCards() {
        when(creditCardService.getAll()).thenReturn(creditCardList);

        List<CreditCard> result = creditCardServiceImpl.getAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).isEqualTo(creditCardList);
        assertThat(result.size()).isEqualTo(creditCardList.size());
        verify(creditCardService, times(1)).getAll();
    }

    @Test
    void shouldReturnCreditCardSaved() {
        when(creditCardService.saveOrUpdate(any(CreditCard.class))).thenReturn(creditCardOne);

        CreditCard result = creditCardServiceImpl.save(creditCardOne);

        assertThat(result.getId()).isNotNull();
        verify(creditCardService, times(1)).saveOrUpdate(any(CreditCard.class));
    }

    @Test
    void shouldReturnTrueIfCreditCardDeleted() {
        when(creditCardService.deleteById(creditCardOne.getId())).thenReturn(true);

        assertThat(creditCardServiceImpl.deleteById(creditCardOne.getId())).isTrue();
        verify(creditCardService, times(1)).deleteById(anyLong());
    }
}