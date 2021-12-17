package com.aacademy.gitdemo.service;

import com.aacademy.gitdemo.model.Person;

import java.util.Set;

public interface PersonService {

    Person findById(Long id);

    Set<Person> findAll();

    Person save(Person person);

    Person update(Long id, Person person);

    void delete(Long id);

    void delete(String name);
}
