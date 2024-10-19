package com.example.OneToManyMappingGlobal.model;

import jakarta.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Book {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

 
    
    public Book() {}
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

//	public Author getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(Author author) {
//		this.author = author;
//	}

   
}