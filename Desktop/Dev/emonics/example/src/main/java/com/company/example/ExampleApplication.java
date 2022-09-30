package com.company.example;

import com.company.example.model.Phone;
import com.company.example.model.User;
import com.company.example.service.contracts.PhoneDAO;
import com.company.example.service.contracts.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ExampleApplication {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private PhoneDAO phoneDAO;

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(){
		return args -> {

			//generateData();
			List<Phone> phones = (List<Phone>) phoneDAO.findAll("modelName:asc", "brand:Apple%,price>900%,");
			System.out.println(phones);
			/*
			User test = userDAO.findByEmail("fernando@email.com").get();
			System.out.println(test.toString());
			test.setName("Luis");
			userDAO.save(test);
			System.out.println(test);

			 */
		};
	}

	public void generateData(){
		/*
		User fernando = new User(null,"Fernando","fernando@email.com","1234");
		User priyanka = new User(null,"Priyanka","priyanka@email.com","1234");
		userDAO.save(fernando);
		userDAO.save(priyanka);

		 */
		Phone phone = new Phone(null,"Iphone13","Apple","white",
				2022,999.99d,"124GB");
		phoneDAO.save(phone);
		Phone phone1 = new Phone(null,"Iphone12","Apple","white",
				2021,899.99d,"124GB");
		Phone phone2 = new Phone(null,"Galaxy S20","Samsung","white",
				2022,999.99d,"124GB");
		phoneDAO.save(phone1);
		phoneDAO.save(phone2);
	}
}
