package com.example.creditcardtest.service;

import com.example.creditcardtest.entity.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl {
    private final CreditCardService creditCardService;

    @Autowired
    public CreditCardServiceImpl(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    public List<CreditCard> getAll() {
        return creditCardService.getAll();
    }

    public CreditCard save(CreditCard creditCard) {
        return creditCardService.saveOrUpdate(creditCard);
    }

    public CreditCard update(CreditCard creditCard) {
        return creditCardService.saveOrUpdate(creditCard);
    }

    public Boolean deleteById(Long id) {
        return creditCardService.deleteById(id);
    }
}
