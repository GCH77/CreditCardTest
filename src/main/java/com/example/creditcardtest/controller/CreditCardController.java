package com.example.creditcardtest.controller;

import com.example.creditcardtest.entity.CreditCard;
import com.example.creditcardtest.service.CreditCardServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "CreditCards")
@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {
    private final CreditCardServiceImpl creditCardService;

    @Autowired
    public CreditCardController(CreditCardServiceImpl creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all credit cards registered", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<CreditCard>> getAll() {
        return new ResponseEntity<>(creditCardService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Register the info's credit card (format correct date = yyyy-MM-dd)", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 201, message = "CREATED")
    public ResponseEntity<CreditCard> save(@RequestBody CreditCard creditCard) {
        return new ResponseEntity<>(creditCardService.save(creditCard), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update the info's credit card (format correct date = yyyy-MM-dd)", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<CreditCard> update(@RequestBody CreditCard creditCard) {
        return new ResponseEntity<>(creditCardService.save(creditCard), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete the info's credit card registered", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(creditCardService.deleteById(id), HttpStatus.OK);
    }

}
