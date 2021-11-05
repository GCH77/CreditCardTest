package com.example.creditcardtest.repository;

import com.example.creditcardtest.entity.CreditCard;
import com.example.creditcardtest.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreditCardRepositoryImpl implements CreditCardService {
    private final CreditCardCrudRepository creditCardCrudRepository;

    @Autowired
    public CreditCardRepositoryImpl(CreditCardCrudRepository creditCardCrudRepository) {
        this.creditCardCrudRepository = creditCardCrudRepository;
    }

    @Override
    public List<CreditCard> getAll() {
        return creditCardCrudRepository.findAll();
    }

    @Override
    public CreditCard saveOrUpdate(CreditCard creditCard) {
        return creditCardCrudRepository.save(creditCard);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (creditCardCrudRepository.existsById(id)) {
            creditCardCrudRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
