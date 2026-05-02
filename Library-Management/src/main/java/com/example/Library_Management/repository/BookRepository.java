
package com.example.Library_Management.repository;

import java.util.List;
import com.example.Library_Management.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Books, Long> {
    @Query("SELECT b FROM Books b JOIN b.author a")
    List<Object[]> findBooksWithAuthors();
}