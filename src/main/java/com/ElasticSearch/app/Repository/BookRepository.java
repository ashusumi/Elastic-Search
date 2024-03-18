package com.ElasticSearch.app.Repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.ElasticSearch.app.Model.Books;

public interface BookRepository extends ElasticsearchRepository<Books, String> {

	@Query("{\"bool\": {\"should\": [{\"match\": {\"name\": \"?0\"}}, {\"match\": {\"author\": \"?0\"}}]}}")
	List<Books> findByNameOrAuthor(String query);

}
