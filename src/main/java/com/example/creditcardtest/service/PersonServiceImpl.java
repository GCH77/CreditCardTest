package com.example.creditcardtest.service;

import com.example.creditcardtest.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class PersonServiceImpl {
    private final PersonService personService;
    private SimpleDateFormat dateFormat;

    @Autowired
    public PersonServiceImpl(PersonService personService) {
        this.personService = personService;
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

    public List<Person> getAll() {
        return personService.getAll();
    }

    public Person save(Person person) {
        return personService.saveOrUpdate(person);
    }

    public Person update(Person person) {
        return personService.saveOrUpdate(person);
    }

    public Boolean deleteById(Long id) {
        return personService.deleteById(id);
    }
}
