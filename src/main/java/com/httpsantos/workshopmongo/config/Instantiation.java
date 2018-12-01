package com.httpsantos.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.httpsantos.workshopmongo.domain.Post;
import com.httpsantos.workshopmongo.domain.User;
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

		Post post1 = new Post(null, sdf.parse("01/12/2018"), "Partiu Viagem", "Vou viajar para São Paulo", maria);
		Post post2 = new Post(null, sdf.parse("01/12/2018"), "Bom dia", "Acordei feliz hoje!", maria);

		repo.saveAll(Arrays.asList(maria, jorge, karol));
		post.saveAll(Arrays.asList(post1, post2));
	}
}
