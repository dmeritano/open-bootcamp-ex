package com.dmeritano.spring.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String title;
	private String author;
	private Integer pages;
	private Double price;
	private LocalDate releaseDate;
	private Boolean ebookVersion;
	
	public Book() {
		
	}

	
	public Book(Long id, String title, String author, Integer pages, Double price, LocalDate releaseDate,
			Boolean ebookVersion) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.price = price;
		this.releaseDate = releaseDate;
		this.ebookVersion = ebookVersion;
	}



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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Boolean getEbookVersion() {
		return ebookVersion;
	}

	public void setEbookVersion(Boolean ebookVersion) {
		this.ebookVersion = ebookVersion;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", pages=" + pages + ", price=" + price
				+ ", releaseDate=" + releaseDate + ", ebookVersion=" + ebookVersion + "]";
	}
	
	

	
	
}
