package com.bookclub.service.dao;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.GenericCrudDao;


/**
 * 
 * Kasi Viswanath, (2022). CIS 530 Server Side Java Programming. Bellevue University, all
 * 
 * rights reserved.
 * 
 * Purpose: BookDao interface used to retrieve wishlist data.
 * 
 */
public interface WishlistDao extends GenericCrudDao<WishlistItem, String> {
}
