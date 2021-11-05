package com.example.creditcardtest.repository;

import com.example.creditcardtest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonCrudRepository extends JpaRepository<Person, Long> {
}
