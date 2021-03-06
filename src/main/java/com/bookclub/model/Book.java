package com.bookclub.model;

/**
 * 
 * Kasi Viswnath, (2022). CIS 530 Server Side Java Programming. Bellevue University, all
 * 
 * rights reserved. Purpose: Book class provides template for an object representing book for
 * Bookclub Spring Boot application.
 * 
 */
public class Book {
  private String isbn;
  private String title;
  private String description;
  private String infoUrl;
  private int numOfPages;


  public Book() {}

  public Book(String isbn, String title, String description, String infoUrl, int numOfPages) {
    this.isbn = isbn;
    this.title = title;
    this.description = description;
    this.infoUrl = infoUrl;
    this.numOfPages = numOfPages;

  }

  public Book(String isbn, String title, String infoUrl) {
    this.isbn = isbn;
    this.title = title;
    this.infoUrl = infoUrl;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setNumOfPages(int numOfPages) {
    this.numOfPages = numOfPages;
  }

  public int getNumOfPages() {
    return numOfPages;
  }



  /**
   * @return the infoUrl
   */
  public String getInfoUrl() {
    return infoUrl;
  }

  /**
   * @param infoUrl the infoUrl to set
   */
  public void setInfoUrl(String infoUrl) {
    this.infoUrl = infoUrl;
  }

  @Override
  public String toString() {
    return String.format("Book{isbn=%s, title=%s, description=%s, numOfPages=%s, authors=%s}", isbn,
        title, description, numOfPages, infoUrl);
  }
}
