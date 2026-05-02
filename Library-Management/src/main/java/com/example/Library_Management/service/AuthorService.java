package com.example.Library_Management.service;

import com.example.Library_Management.model.authors;
import com.example.Library_Management.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public authors saveAuthor(authors author) {
        return authorRepository.save(author);
    }

    public List<authors> getAllAuthors() {
        return authorRepository.findAll();
    }

    public authors getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

}