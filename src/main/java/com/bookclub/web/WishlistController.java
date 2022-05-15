package com.bookclub.web;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishlistDao;

/**
 * 
 * Kasi Viswanath, (2022). CIS 530 Server Side Java Programming. Bellevue University, all
 * 
 * rights reserved.
 * 
 * Purpose: WishlistController class used to show wishlist page.
 * 
 */
@Controller
@RequestMapping("/wishlist")
public class WishlistController {

  WishlistDao wishlistDao = new MongoWishlistDao();

  @Autowired
  private void setWishlistDao(WishlistDao wishlistDao) {
    this.wishlistDao = wishlistDao;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String showWishlist() {
    return "wishlist/list";
  }

  @RequestMapping(method = RequestMethod.GET, path = "/new")
  public String wishlistForm(Model model) {
    model.addAttribute("wishlistItem", new WishlistItem());
    return "wishlist/new";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult,
      Authentication authentication) {
    wishlistItem.setUsername(authentication.getName());

    if (bindingResult.hasErrors()) {
      return "wishlist/new";
    }

    wishlistDao.add(wishlistItem); // add the record to MongoDB

    return "redirect:/wishlist";
  }

  @RequestMapping(method = RequestMethod.GET, path = "/remove/{id}")
  public String removeWishlistItem(@PathVariable String id) {

    wishlistDao.remove(id);

    return "redirect:/wishlist";
  }

  @RequestMapping(method = RequestMethod.GET, path = "/{id}")
  public String showWishlistItem(@PathVariable String id, Model model) {
    WishlistItem wishlistItem = wishlistDao.find(id);

    model.addAttribute("wishlistItem", wishlistItem);

    return "wishlist/view";
  }

  @RequestMapping(method = RequestMethod.POST, path = "/update")
  public String updateWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult,
      Authentication authentication) {
    wishlistItem.setUsername(authentication.getName());

    if (bindingResult.hasErrors()) {
      return "wishlist/view";
    }

    wishlistDao.update(wishlistItem);

    return "redirect:/wishlist";
  }
}
