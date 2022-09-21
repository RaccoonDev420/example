package com.company.example;

import com.company.example.model.User;
import com.company.example.service.contracts.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class ExampleApplication {

	@Autowired
	private UserDAO userDAO;

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(){
		return args -> {
			generateData();
			User test = userDAO.findByEmail("fernando@email.com").get();
			System.out.println(test.toString());
			test.setName("Luis");
			userDAO.save(test);
			System.out.println(test);
		};
	}

	public void generateData(){
		User fernando = new User(null,"Fernando","fernando@email.com","1234");
		User priyanka = new User(null,"Priyanka","priyanka@email.com","1234");
		userDAO.save(fernando);
		userDAO.save(priyanka);
	}
}
