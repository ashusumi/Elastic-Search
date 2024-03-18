package com.ElasticSearch.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ElasticSearch.app.Model.Books;
import com.ElasticSearch.app.Service.BooksService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BooksService impl;

	@PostMapping
	public String addBooks(@RequestBody Books book) {

		return impl.addBooks(book);
	}

	@GetMapping
	public Iterable<Books> getAllBooks() {
		return impl.getAllBooks();
	}

	@GetMapping("/{id}")
	public Books getBookById(@PathVariable String id) {
		return impl.findBookById(id);
	}

	@GetMapping("/search")
	public List<Books> searchBook(@RequestParam String query) {
		return impl.searchBook(query);
	}

}
