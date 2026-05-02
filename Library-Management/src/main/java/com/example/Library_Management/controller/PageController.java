package com.example.Library_Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Library_Management.repository.AuthorRepository;

@Controller
public class PageController {
    @GetMapping("/")
    public String home() {
        return "index"; // index.jsp
    }

    // Redirect back to home page
    @GetMapping("/home")
    public String goHome() {
        return "index";
    }

    // Books
    @GetMapping("/books-page")
    public String booksPage() {
        return "redirect:/books";
    }

    @Autowired
    private AuthorRepository AuthorRepository;

    @GetMapping("/debug")
    @ResponseBody
    public String debug() {
        long count = AuthorRepository.count();
        return "Author count from REPO: " + count;
    }

    // Authors
    @GetMapping("/authors-page")
    public String authorsPage() {
        return "redirect:/authors";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "ok";
    }

}
