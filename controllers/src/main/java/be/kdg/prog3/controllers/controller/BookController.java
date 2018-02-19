package be.kdg.prog3.controllers.controller;

import be.kdg.prog3.controllers.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @GetMapping("/books")
    public String showNewBookPage() {
        return "books/new_book";
    }

    @PostMapping("/books")
    public ModelAndView addBook(@RequestParam String title, @RequestParam String author) {
        Book newBook = new Book(title, author);
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("book", newBook);
        modelAndView.setViewName("books/book_added");
        return modelAndView;
    }
}
