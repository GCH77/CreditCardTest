package com.example.creditcardtest.controller;

import com.example.creditcardtest.entity.Person;
import com.example.creditcardtest.service.PersonServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Persons")
@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonServiceImpl personService;

    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all the people register", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Person>> getAll() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Register the info's person (format correct date = yyyy-MM-dd)", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 201, message = "CREATED")
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return new ResponseEntity<>(personService.save(person), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update the info's person registered", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Person> update(@RequestBody Person person) {
        return new ResponseEntity<>(personService.save(person), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete the info's person registered", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(personService.deleteById(id), HttpStatus.OK);
    }
}
