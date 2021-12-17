package com.aacademy.gitdemo.repository;

import com.aacademy.gitdemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByName(String name);

    void deleteByName(String name);
}
