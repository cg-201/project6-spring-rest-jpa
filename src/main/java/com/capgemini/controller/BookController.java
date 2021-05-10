package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Author;
import com.capgemini.entities.Book;
import com.capgemini.repository.AuthorRepository;
import com.capgemini.repository.BookRepository;

@RestController
@RequestMapping("/api/book/")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;
	
	@PostMapping("/")
	public String create(@RequestBody Book book) {
		
		bookRepository.save(book);
		
		return "Book Entry Created";
	}
	
	
	@GetMapping("/{id}")
	public Book findById(@PathVariable int id) {
		
		return bookRepository.findById(id).get();
	}
	
	
	@PutMapping("/{bookId}/author/{authorId}")
	public String assignAuthor(@PathVariable int bookId, @PathVariable int authorId) {
		
		Book book = bookRepository.findById(bookId).get();
		Author author = authorRepository.findById(authorId).get();
		
		book.getAuthors().add(author);
		bookRepository.save(book);
		
		return "Author assigned";
	}

}
