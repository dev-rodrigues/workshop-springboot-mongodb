package com.httpsantos.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.httpsantos.workshopmongo.domain.Post;
import com.httpsantos.workshopmongo.domain.User;
import com.httpsantos.workshopmongo.dto.AuthorDTO;
import com.httpsantos.workshopmongo.dto.CommentDTO;
import com.httpsantos.workshopmongo.repository.PostRepository;
import com.httpsantos.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository repo;

	@Autowired
	private PostRepository post;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		repo.deleteAll();
		post.deleteAll();

		User maria = new User(null, "Maria Silva", "mari@gmail.com");
		User jorge = new User(null, "Jorge Silva", "jorge@gmail.com");
		User karol = new User(null, "Karol Silva", "karol@gmail.com");

		repo.saveAll(Arrays.asList(maria, jorge, karol));

		Post post1 = new Post(null, sdf.parse("01/12/2018"), "Partiu Viagem", "Vou viajar para São Paulo",
				new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("01/12/2018"), "Bom dia", "Acordei feliz hoje!", 
				new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("02/12/2018"), new AuthorDTO(jorge));
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("02/12/2018"), new AuthorDTO(karol));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("02/12/2018"), new AuthorDTO(karol));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		post.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		repo.save(maria);
	}
}