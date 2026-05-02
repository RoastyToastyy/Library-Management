package com.example.Library_Management.repository;

import java.util.List;
import com.example.Library_Management.model.Books;
import com.example.Library_Management.model.authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<authors, Long> {
    @Query("SELECT b FROM Books b JOIN b.author a WHERE a.fname = ?1")
    List<Books> findBooksByAuthorFname(String fname);
}
