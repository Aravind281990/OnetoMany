package com.example.OneToManyMappingGlobal;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;

import java.util.*;

import com.example.OneToManyMappingGlobal.exception.InvalidAuthorIdException;
import com.example.OneToManyMappingGlobal.model.Author;
import com.example.OneToManyMappingGlobal.model.Book;
import com.example.OneToManyMappingGlobal.repository.AuthorRepository;
import com.example.OneToManyMappingGlobal.repository.BookRepository;
import com.example.OneToManyMappingGlobal.service.AuthorService;
import com.example.OneToManyMappingGlobal.service.BookService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class OneToManyMappingGlobalApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	
	@InjectMocks
    private AuthorService authorService;

    @Mock
    private AuthorRepository authorRepository;
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testCreateAuthor() {
        Author author = new Author();
        author.setId(3000L);
        author.setName("Rohan");
        Book b=new Book();
	b.setId(2002L);
	b.setTitle("C");
	//	b.setAuthor(a);
		Book b1=new Book();
		b1.setId(2003L);
		b1.setTitle("Java");
		//b1.setAuthor(a);
		List<Book> book=new ArrayList();
		book.add(b);
		book.add(b1);
		author.setBooks(book);

        Mockito.when(authorRepository.save(Mockito.any(Author.class))).thenReturn(author);

        Author savedAuthor = authorService.createAuthor(author);
System.out.println(savedAuthor.getName());
        Assert.assertEquals("Rohan", savedAuthor.getName());
    }
    
    @Test
    public void testGetBookById() {
        Long bookId = 1L;
        Book book = new Book();
        book.setId(bookId);
        book.setTitle("C#");

        Mockito.when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        Book foundBook = bookService.getBookById(bookId);

        Assert.assertNotNull(foundBook);
        Assert.assertEquals("C#", foundBook.getTitle());
    }

    @Test
    public void testDeleteBookById() {
        Long bookId = 1L;

        Mockito.doNothing().when(bookRepository).deleteById(bookId);

      
        bookService.deleteBookById(bookId);

        Mockito.verify(bookRepository, Mockito.times(1)).deleteById(bookId);
    }

    @Test
    public void testGetAllBooks() {
        
        List<Book> sampleBooks = new ArrayList<>();
        Book b=new Book();
        b.setId(1L);
        b.setTitle("Book1");
        Book b1=new Book();
        b1.setId(2L);
        b1.setTitle("Book2");
        sampleBooks.add(b);
        sampleBooks.add(b1);

        
        Mockito.when(bookRepository.findAll()).thenReturn(sampleBooks);

        List<Book> result = bookService.getAllBooks();
       
        Assert.assertEquals(sampleBooks.size(), result.size());
        for (int i = 0; i < sampleBooks.size(); i++) {
            Assert.assertEquals(sampleBooks.get(i).getId(), result.get(i).getId());
            Assert.assertEquals(sampleBooks.get(i).getTitle(), result.get(i).getTitle());
        }
    }
    
    @Test
    public void testGetAuthorByIdNotFound() {
        Long nonExistentAuthorId = 999L;

      
        Mockito.when(authorRepository.findById(nonExistentAuthorId)).thenReturn(Optional.empty());

        InvalidAuthorIdException exception = assertThrows(InvalidAuthorIdException.class, () -> {
            authorService.getAuthorById(nonExistentAuthorId);
        });

        
        // Verify that findById was called with the expected ID
        verify(authorRepository).findById(nonExistentAuthorId);
    }



}













    

