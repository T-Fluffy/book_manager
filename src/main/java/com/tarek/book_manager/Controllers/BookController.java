package com.tarek.book_manager.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarek.book_manager.Services.BookService;

@Controller
public class BookController {
    
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBookService(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }    

}
