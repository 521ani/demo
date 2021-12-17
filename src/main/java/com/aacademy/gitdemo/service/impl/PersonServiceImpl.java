package com.aacademy.gitdemo.service.impl;

import com.aacademy.gitdemo.model.Person;
import com.aacademy.gitdemo.repository.PersonRepository;
import com.aacademy.gitdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Set<Person> findAll() {
        SortedSet<Person> persons = new TreeSet<>(Comparator.comparing(Person::getId));
        persons.addAll(personRepository.findAll());

        return persons;
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Long id, Person person) {
        Person foundPerson = this.findById(id);
        Person updatedPerson = Person.builder()
                .id(foundPerson.getId())
                .ucn(person.getUcn())
                .name(person.getName())
                .age(person.getAge())
                .cats(person.getCats())
                .build();

        return personRepository.save(updatedPerson);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void delete(String name) {
        Person foundPerson = personRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);

        personRepository.deleteByName(foundPerson.getName());
    }
}
