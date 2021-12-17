package com.aacademy.gitdemo.controller;

import com.aacademy.gitdemo.model.Cat;
import com.aacademy.gitdemo.model.Person;
import com.aacademy.gitdemo.service.CatService;
import com.aacademy.gitdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/persons")
    public Set<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping(value = "/person/{id}")
    public Person findById(Long id) {
        return personService.findById(id);
    }

    @PostMapping(value = "/save/person")
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete/name/{name}")
    public ResponseEntity<HttpStatus> deleteByName(@PathVariable String name) {
        personService.delete(name);
        return ResponseEntity.ok().build();
    }
}
