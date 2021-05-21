package com.pankaj.spring.data.demo;

import com.pankaj.spring.data.demo.controller.AuthorController;
import com.pankaj.spring.data.demo.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	AuthorController authorController;

	@Test
	void persistAndGetAuthors() {
		Author a = new Author();
		a.setFirstName("Pankaj");
		a.setLastName("Agarwal");

		authorController.persistAuthor(a);

		authorController.getAuthorById(a.getId());
	}

}
