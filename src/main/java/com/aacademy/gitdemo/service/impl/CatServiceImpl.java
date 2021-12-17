package com.aacademy.gitdemo.service.impl;

import com.aacademy.gitdemo.model.Cat;
import com.aacademy.gitdemo.repository.CatRepository;
import com.aacademy.gitdemo.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    @Autowired
    public CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public Set<Cat> findAll() {
        SortedSet<Cat> cats = new TreeSet<>(Comparator.comparing(Cat::getId));
        cats.addAll(catRepository.findAll());

        return cats;
    }

    @Override
    public Cat save(Cat cat) {
        return catRepository.save(cat);
    }

    @Override
    public Cat update(Long id, Cat cat) {
        Cat foundCat = this.findById(id);
        Cat updatedCat = Cat.builder()
                .id(foundCat.getId())
                .name(cat.getName())
                .birthDate(cat.getBirthDate())
                .owner(cat.getOwner())
                .build();

        return catRepository.save(updatedCat);
    }

    @Override
    public void delete(Long id) {
        catRepository.deleteById(id);
    }

    @Override
    public void delete(String name) {
        Cat foundCat = catRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);

        catRepository.deleteByName(foundCat.getName());
    }

    @Override
    public Cat findById(Long id) {
        return catRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }
}
