package com.bookclub.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

/**
 * 
 * Kasi Viswanath, (2022). CIS 530 Server Side Java Programming. Bellevue University, all
 * 
 * rights reserved.
 * 
 * Purpose: WishlistItem class provides template for an object representing Wishlist for Bookclub
 * Spring Boot application.
 * 
 */
public class WishlistItem {

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  @Id
  private String id;

  @NotNull
  @NotEmpty(message = "ISBN is a required field.")
  private String isbn;

  @NotNull
  @NotEmpty(message = "Title is a required field.")
  private String title;

  public WishlistItem() {}

  public WishlistItem(String isbn, String title) {
    this.isbn = isbn;
    this.title = title;
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

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "WishlistItem [isbn=" + isbn + ", title=" + title + "]";
  }


}
