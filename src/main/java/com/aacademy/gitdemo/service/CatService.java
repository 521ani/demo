package com.aacademy.gitdemo.service;

import com.aacademy.gitdemo.model.Cat;
import com.aacademy.gitdemo.model.Person;

import java.util.Set;

public interface CatService {

    Cat findById(Long id);

    Set<Cat> findAll();

    Cat save(Cat cat);

    Cat update(Long id, Cat cat);

    void delete(Long id);

    void delete(String name);
}
