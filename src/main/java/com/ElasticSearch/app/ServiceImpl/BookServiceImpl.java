package com.ElasticSearch.app.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ElasticSearch.app.Model.Books;
import com.ElasticSearch.app.Repository.BookRepository;
import com.ElasticSearch.app.Service.BooksService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BooksService {

	@Autowired
	private BookRepository repo;

	@Override
	public String addBooks(Books books) {
		try {
			Books b = Books.builder().name(books.getName()).author(books.getAuthor()).price(books.getPrice()).build();
			repo.save(b);

			return "Books added succesfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public Iterable<Books> getAllBooks() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}

	}

	@Override
	public Books findBookById(String id) {
		try {
			return repo.findById(id).orElse(null);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Books> searchBook(String query) {

		return repo.findByNameOrAuthor(query);
	}

}
