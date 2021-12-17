package com.aacademy.gitdemo.controller;

import com.aacademy.gitdemo.model.Cat;
import com.aacademy.gitdemo.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class CatControler {

    private final CatService catService;

    @Autowired
    public CatControler(CatService catService) {
        this.catService = catService;
    }

    @GetMapping(value = "/cats")
    public Set<Cat> findAll() {
        return catService.findAll();
    }

    @GetMapping(value = "/cat/{id}")
    public Cat findById(Long id) {
        return catService.findById(id);
    }

    @PostMapping(value = "/save/cat")
    public ResponseEntity<Cat> save(@RequestBody Cat cat) {
        return ResponseEntity.status(HttpStatus.CREATED).body(catService.save(cat));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        catService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete/name/{name}")
    public ResponseEntity<HttpStatus> deleteByName(@PathVariable String name) {
        catService.delete(name);
        return ResponseEntity.ok().build();
    }
}
