package com.wiley.bookpub.model;

public class Skillstore {
	private int id;
	private String bookName;
	private int isbn;
	private String author;
	private int edition;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public Skillstore(int id, String bookName, int isbn, String author, int edition) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.isbn = isbn;
		this.author = author;
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "Skillstore [id=" + id + ", bookName=" + bookName + ", isbn=" + isbn + ", author=" + author
				+ ", edition=" + edition + "]";
	}

}