package com.example.creditcardtest.service;

import com.example.creditcardtest.entity.CreditCard;

import java.util.List;

public interface CreditCardService {
    List<CreditCard> getAll();
    CreditCard saveOrUpdate(CreditCard creditCard);
    Boolean deleteById(Long id);
}
