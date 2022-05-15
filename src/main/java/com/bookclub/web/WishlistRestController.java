package com.bookclub.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishlistDao;

/**
 * 
 * Kasi Viswanath, (2022). CIS 530 Server Side Java Programming. Bellevue University, all
 * 
 * rights reserved.
 * 
 * Purpose: WishlistRestController class used to show wishlist page.
 * 
 */
@RestController
@RequestMapping(path = "/api/wishlist", produces = "application/json")
@CrossOrigin(origins = "*")
public class WishlistRestController {
  WishlistDao wishlistDao = new MongoWishlistDao();

  @Autowired
  private void setWishlistDao(WishlistDao wishlistDao) {
    this.wishlistDao = wishlistDao;
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<WishlistItem> showWishlist(Authentication authentication) {
    String username = authentication.getName();

    return wishlistDao.list(username);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public WishlistItem findById(@PathVariable String id) {
    return wishlistDao.find(id);
  }
}
