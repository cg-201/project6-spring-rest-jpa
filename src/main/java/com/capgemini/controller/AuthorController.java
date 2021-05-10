package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Author;
import com.capgemini.repository.AuthorRepository;

@RestController
@RequestMapping("/api/author/")
public class AuthorController {
	
	@Autowired
	private AuthorRepository authorRepository;

	@PostMapping
	public String create(@RequestBody Author author) {
		
		authorRepository.save(author);
		
		return "Author Created!!";
	}
	
	
	@GetMapping("/{id}")
	public Author findById(@PathVariable int id) {
		
		return authorRepository.findById(id).get();
	}
}
