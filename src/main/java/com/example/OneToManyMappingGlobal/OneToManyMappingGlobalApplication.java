package com.example.OneToManyMappingGlobal;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.OneToManyMappingGlobal.model.Author;
import com.example.OneToManyMappingGlobal.model.Book;
import com.example.OneToManyMappingGlobal.repository.AuthorRepository;

@SpringBootApplication
@EnableConfigurationProperties
//@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages={"com.example.*"})
@EntityScan(basePackages = {"com.example.OneToManyMappingGlobal.model"})
@EnableJpaRepositories("com.example.OneToManyMappingGlobal.repository")
public class OneToManyMappingGlobalApplication implements CommandLineRunner {

	@Autowired
	public AuthorRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(OneToManyMappingGlobalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Author a=new Author();
//		a.setId(1001L);
//		a.setName("Bhagya");
//		Book b=new Book();
//		b.setId(2002L);
//		b.setTitle("C");
//		b.setAuthor(a);
//		Book b1=new Book();
//		b1.setId(2003L);
//		b1.setTitle("Java");
//		b1.setAuthor(a);
//		List<Book> book=new ArrayList();
//		book.add(b);
//		book.add(b1);
//		a.setBooks(book);
//		repo.save(a);
//		System.out.println("saved");
//		
		
	}

}
