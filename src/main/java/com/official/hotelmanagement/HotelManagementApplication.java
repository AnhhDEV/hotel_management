package com.official.hotelmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@SpringBootApplication
public class HotelManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(PostRepository posts, AuthorRepository authors) {
//		return args -> {
//			AggregateReference<Author, Integer> me = AggregateReference.to(authors.save(new Author(null, "Tuan", "Bui", "tan@gmail.com", "bosmodel")).id());
//			Post post = new Post("Hello world", "welcome to my blog", me);
//			post.addComment(new Comment("Insult", "Fuck you bitch!"));
//			posts.save(post);
//		};
//	}

}
