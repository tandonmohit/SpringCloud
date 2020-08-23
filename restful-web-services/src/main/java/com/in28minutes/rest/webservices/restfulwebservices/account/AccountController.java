package com.in28minutes.rest.webservices.restfulwebservices.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountDAO service;

    @GetMapping("/accounts")
    public List<Account> retrieveAllAccounts() {
            return service.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account retrieveAccount(@PathVariable int id) {
        Account account=service.findOne(id);
        if(account==null)
            throw new AccountNotFoundException("id= "+id);
        return account;
    }

    @PostMapping("/accounts")
    public ResponseEntity<Object> createAccount(@RequestBody Account account) {
        Account newAccount= service.save(account);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAccount.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
