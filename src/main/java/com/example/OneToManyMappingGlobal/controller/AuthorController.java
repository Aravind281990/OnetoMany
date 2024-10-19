package com.example.OneToManyMappingGlobal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.example.OneToManyMappingGlobal.exception.InvalidAuthorIdException;
import com.example.OneToManyMappingGlobal.model.Author;
import com.example.OneToManyMappingGlobal.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/listallauthors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("/addauthor")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }
       

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id)throws InvalidAuthorIdException {
        return authorService.getAuthorById(id);
    }

    @DeleteMapping("delbyAuthorId/{id}")
    public void deleteAuthorById(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
    }

    
}