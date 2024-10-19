package com.example.OneToManyMappingGlobal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.OneToManyMappingGlobal.exception.GlobalExceptionHandler;
import com.example.OneToManyMappingGlobal.exception.InvalidAuthorIdException;
import com.example.OneToManyMappingGlobal.model.Author;
import com.example.OneToManyMappingGlobal.repository.AuthorRepository;
import java.util.*;
@Service
public class AuthorService {
    @Autowired(required=true)
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author createAuthor(Author author) {
    	System.out.println("before saving");
    
         authorRepository.save(author);
         System.out.println("after saving");
    	
    	
         return author;
    }

    public Author getAuthorById(Long id) throws InvalidAuthorIdException{
    	Author a1=null;
        Optional<Author> a=authorRepository.findById(id);
        if(a.isPresent())
        {
        	 a1=a.get();
        }
        else
        {
        	throw new InvalidAuthorIdException();
        }
        return a1;
    }

    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }


}
