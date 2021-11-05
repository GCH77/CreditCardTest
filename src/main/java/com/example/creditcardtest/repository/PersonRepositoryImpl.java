package com.example.creditcardtest.repository;

import com.example.creditcardtest.entity.Person;
import com.example.creditcardtest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonService {

    private final PersonCrudRepository personCrudRepository;

    @Autowired
    public PersonRepositoryImpl(PersonCrudRepository personCrudRepository) {
        this.personCrudRepository = personCrudRepository;
    }

    @Override
    public List<Person> getAll() {
        return personCrudRepository.findAll();
    }

    @Override
    public Person saveOrUpdate(Person person) {
        return personCrudRepository.save(person);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (personCrudRepository.existsById(id)) {
            personCrudRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
