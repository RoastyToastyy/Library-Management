package com.example.Library_Management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Library_Management.model.Books;
import com.example.Library_Management.model.authors;
import com.example.Library_Management.repository.BookRepository;
import com.example.Library_Management.repository.AuthorRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public List<Books> findAll() {
        return bookRepository.findAll();
    }

    public Books getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Books save(Books book, Long authorId) {
        authors author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        book.setAuthor(author);
        return bookRepository.save(book);
    }
}