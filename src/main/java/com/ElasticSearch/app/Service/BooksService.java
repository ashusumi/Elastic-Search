package com.ElasticSearch.app.Service;

import java.util.List;

import com.ElasticSearch.app.Model.Books;

public interface BooksService {

	String addBooks(Books books);

	Iterable<Books> getAllBooks();

	Books findBookById(String id);

	List<Books> searchBook(String query);

}
