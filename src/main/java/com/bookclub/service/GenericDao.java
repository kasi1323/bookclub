package com.bookclub.service;

import java.util.List;

/**
 * 
 * Kasi Viswanath, (2022). CIS 530 Server Side Java Programming. Bellevue University, all
 * 
 * rights reserved. Purpose: GenericDao interface provides generic methods to retrieve data.
 * 
 */
public interface GenericDao<E, K> {

  // Return a list of objects of type E.
  List<E> list(String key);

  // Return an object of type E by type K value.
  E find(K key);
}
