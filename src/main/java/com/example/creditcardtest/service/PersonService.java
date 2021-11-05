package com.example.creditcardtest.service;

import com.example.creditcardtest.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAll();
    Person saveOrUpdate(Person person);
    Boolean deleteById(Long id);
}
