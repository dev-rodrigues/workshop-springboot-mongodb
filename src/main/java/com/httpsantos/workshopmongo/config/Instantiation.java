package com.httpsantos.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.httpsantos.workshopmongo.domain.User;
import com.httpsantos.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository	repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		repo.deleteAll();
		
		User maria = new User(null, "Maria Silva", "mari@gmail.com");
		User jorge = new User(null, "Jorge Silva", "jorge@gmail.com");
		User karol = new User(null, "Karol Silva", "karol@gmail.com");
		
		repo.saveAll(Arrays.asList(maria,jorge,karol));
		
	}
}
