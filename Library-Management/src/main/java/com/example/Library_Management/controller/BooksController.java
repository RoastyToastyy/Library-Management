package com.example.Library_Management.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Library_Management.model.Books;
import com.example.Library_Management.service.BookService;
import com.example.Library_Management.service.AuthorService;

@Controller
@RequestMapping("/books")
public class BooksController {

    private static final Logger logger = LoggerFactory.getLogger(BooksController.class);
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    // Read
    @GetMapping
    public String getAllBooks(Model model) {
        List<Books> books = bookService.findAll();
        logger.info("Fetching all books");
        model.addAttribute("books", books);
        return "book-list";
    }

    // View created
    @GetMapping("/new")
    public String bookForm(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "book-form";
    }

    // Create
    @PostMapping("/save")
    public String createBook(@ModelAttribute Books book,
            @RequestParam Long authorId,
            Model model) {
        try {
            logger.info("Creating book: {}", book);
            bookService.save(book, authorId);
            return "redirect:/books";
        } catch (Exception e) {
            logger.error("Error creating book", e);
            model.addAttribute("error", "Error creating book");
            model.addAttribute("authors", authorService.getAllAuthors());
            return "book-form";
        }
    }

    // Update view
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        logger.info("Editing book with id: {}", id);
        model.addAttribute("book", bookService.getBookById(id));
        model.addAttribute("authors", authorService.getAllAuthors());
        return "book-update";
    }

    // Update
    @PostMapping("/update")
    public String updateBook(@ModelAttribute Books book,
            @RequestParam Long authorId) {
        logger.info("Updating book: {}", book);
        bookService.save(book, authorId);
        return "redirect:/books";
    }
}