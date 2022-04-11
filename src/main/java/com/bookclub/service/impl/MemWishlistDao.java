package com.bookclub.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

/**
 * 
 * Kasi Viswanath, (2022). CIS 530 Server Side Java Programming. Bellevue University, all
 * 
 * rights reserved. Purpose: MemWishlistDao class used to retrieve wishlist data.
 */
public class MemWishlistDao implements WishlistDao {
  List<WishlistItem> wishlist;

  /**
   * Initializing wish list items
   * 
   */
  public MemWishlistDao() {
    this.wishlist = new ArrayList<WishlistItem>();
    this.wishlist.add(new WishlistItem("8944339681", "Spring in Action"));
    this.wishlist.add(new WishlistItem("5334103571", "Effective Java"));
    this.wishlist.add(new WishlistItem("5748483225", "Data Structures and Algorithms in Java"));
    this.wishlist.add(new WishlistItem("8734568275", "Hardcore Java"));
  }

  @Override
  public List<WishlistItem> list() {
    return this.wishlist;
  }

  @Override
  public WishlistItem find(String key) {
    for (WishlistItem item : wishlist) {
      if (item.getIsbn().equals(key)) {
        return item;
      }
    }
    return new WishlistItem();
  }
}
