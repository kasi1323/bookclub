package com.bookclub.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bookclub.model.Book;
import com.bookclub.service.impl.MemBookDao;

/**
 * @author kasiv
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {

  @Autowired
  private MemBookDao memBookDao;

  /**
   * @param model
   * @return
   */
  @RequestMapping(method = RequestMethod.GET)
  public String showHome(Model model) {
    MemBookDao bookDao = new MemBookDao();
    List<Book> books = bookDao.list();

    for (Book book : books) {
      System.out.println(book.toString());
    }

    model.addAttribute("books", books);

    return "index";
  }

  /**
   * @param id
   * @param model
   * @return
   */
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public String getMonthlyBook(@PathVariable("id") String isbn, Model model) {


    Book book = memBookDao.find(isbn);

    model.addAttribute("book", book);
    return "monthly-books/view";
  }

  @RequestMapping(method = RequestMethod.GET, path = "/about")
  public String showAboutUs(Model model) {

    return "about";
  }

  @RequestMapping(method = RequestMethod.GET, path = "/contact")
  public String showContactUs(Model model) {

    return "contact";
  }
}
