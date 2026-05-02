package com.example.Library_Management.controller;

import com.example.Library_Management.model.authors;
import com.example.Library_Management.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class authorsController {

    private static final Logger logger = LoggerFactory.getLogger(authorsController.class);

    @Autowired
    private AuthorService authorService;

    // Read
    @GetMapping
    public String getAllAuthors(Model model) {
        List<authors> authorsList = authorService.getAllAuthors();
        logger.info("Fetching all authors");

        model.addAttribute("authors", authorsList);
        return "author-list";
    }

    // View create form
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("author", new authors());
        return "author-form";
    }

    // Create author
    @PostMapping("/save")
    public String createAuthor(@ModelAttribute("author") authors author, Model model) {
        try {
            logger.info("Creating author: {}", author);
            authorService.saveAuthor(author);
            return "redirect:/authors";
        } catch (Exception e) {
            logger.error("Error creating author", e);
            model.addAttribute("error", "Error creating author");
            return "author-form";
        }
    }

    // View update form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        authors existingAuthor = authorService.getAuthorById(id);
        model.addAttribute("author", existingAuthor);
        return "author-update";
    }

    // Update author
    @PostMapping("/update")
    public String updateAuthor(@ModelAttribute("author") authors author, Model model) {
        try {
            logger.info("Updating author: {}", author);
            authorService.saveAuthor(author);
            return "redirect:/authors";
        } catch (Exception e) {
            logger.error("Error updating author", e);
            model.addAttribute("error", "Error updating author");
            return "author-update";
        }
    }
}