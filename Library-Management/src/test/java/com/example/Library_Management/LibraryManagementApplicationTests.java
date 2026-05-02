package com.example.Library_Management;

import com.example.Library_Management.model.Books;
import com.example.Library_Management.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@SpringBootTest
class BookServiceTest {

	@Autowired
	private BookService bookService;

	@Test
	void testFindAllBooks() {
		List<Books> books = bookService.findAll();
		assertThat(books).isNotEmpty();
	}

}