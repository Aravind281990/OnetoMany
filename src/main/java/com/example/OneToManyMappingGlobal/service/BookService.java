package com.example.OneToManyMappingGlobal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OneToManyMappingGlobal.model.Book;
import com.example.OneToManyMappingGlobal.repository.BookRepository;

@Service
public class BookService {
    @Autowired(required=true)
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

 
}