package com.bookclub.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

/**
 * 
 * Kasi Viswanath, (2022). CIS 530 Server Side Java Programming. Bellevue University, all
 * 
 * rights reserved.
 * 
 * Purpose: BookDao class used to retrieve book data.
 * 
 */
@Service
public class MemBookDao implements BookDao {

  private List<Book> books;

  /**
   * Constructor
   * 
   * Initialize books property with static data
   */
  public MemBookDao() {
    this.books = new ArrayList<Book>();
    this.books.add(new Book("8944339681", "Spring in Action",
        "Spring in Action, 5th Edition is the fully updated revision of Manning's bestselling Spring in Action. This new edition includes all Spring 5.0 updates, along with new examples on reactive programming, Spring WebFlux, and microservices. You'll also find the latest Spring best practices, including Spring Boot for application setup and configuration.",
        322, new ArrayList<>(Arrays.asList("Craig Walls"))));
    this.books.add(new Book("5334103571", "Effective Java",
        "Java has changed dramatically since the previous edition of Effective Java was published shortly after the release of Java 6. This Jolt award-winning classic has now been thoroughly updated to take full advantage of the latest language and library features. The support in modern Java for multiple paradigms increases the need for specific best-practices.",
        432, new ArrayList<>(Arrays.asList("Joshua Bloch"))));
    this.books.add(new Book("5748483225", "Data Structures and Algorithms in Java",
        "This new book provides a concise and engaging introduction to Java and object-oriented programming with an abundance of original examples, use of Unified Modeling Language throughout, and coverage of the new Java 1.5. Addressing critical concepts up front, the book's five-part structure covers object-oriented programming, linear structures etc.",
        448, new ArrayList<>(Arrays.asList("Peter Drake"))));
    this.books.add(new Book("8734568275", "Hardcore Java",
        "Java has quickly become one of the most important languages in programming, particularly for professional and enterprise-level projects. From its infancy as a language primarily used for web applets to its maturity through servlets, Enterprise JavaBeans, and database access, Java has become a complex and robust tool for today's developer.",
        432, new ArrayList<>(Arrays.asList("Robert Simmons Jr"))));
    this.books.add(new Book("4567892215", "Java Generics and Collections",
        "This comprehensive guide shows you how to master the most importantchanges to Java since it was first released. Generics and the greatlyexpanded collection libraries have tremendously increased the power ofJava 5 and Java 6. But they have also confused many developers whohaven't known how to take advantage of these new features.",
        688, new ArrayList<>(Arrays.asList("Maurice Naftalin, Philip Wadler"))));
  }

  @Override
  public List<Book> list() {
    return this.books;
  }

  /**
   * param isbn
   * 
   * return Book
   * 
   * filters the given isbn from list and return book
   */
  @Override
  public Book find(String isbn) {

    return this.books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().get();
  }
}
