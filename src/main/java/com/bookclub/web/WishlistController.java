package com.bookclub.web;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

  /**
   * @param model
   * @return
   */
  @RequestMapping(method = RequestMethod.GET, path = "/new")
  public String wishlistForm(Model model) {
    model.addAttribute("wishlistItem", new WishlistItem());
    return "wishlist/new";
  }

  /**
   * @param wishlistItem
   * @param bindingResult
   * @return
   */
  @RequestMapping(method = RequestMethod.POST)
  public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "wishlist/new";
    }
    wishlistDao.add(wishlistItem); // add the record to MongoDB
    return "redirect:/wishlist";
  }
}
