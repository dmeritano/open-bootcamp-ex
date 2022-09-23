package com.dmeritano.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmeritano.spring.entities.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	public List<Book> findByTitle(String title);
	public List<Book> findByAuthor(String author);

}
