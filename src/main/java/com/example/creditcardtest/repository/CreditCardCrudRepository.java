package com.example.creditcardtest.repository;

import com.example.creditcardtest.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardCrudRepository extends JpaRepository<CreditCard, Long> {
}
