package com.packt.cardatabase;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepo;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
	private CarRepo carRepo;

	@Autowired
	private OwnerRepo ownerRepo;
	
	public static void main(String[] args) {
		//This should restart the server, Thanks to Spring DevTools
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started :)");
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("John", "Cena");
		Owner owner2 = new Owner("Mary", "Poppins");
		ownerRepo.saveAll(Arrays.asList(owner1,owner2));

		Car car1 = new Car("Ford", "Mustang", "Red",
				"ADF-1121", 2021, 59000, owner1);
		Car car2 = new  Car("Nissan", "Leaf", "White",
				"SSJ-3002", 2019, 29000, owner2);
		Car car3 = new Car("Toyota", "Prius", "Silver",
				"KKO-0212", 2020, 39000, owner2);
		carRepo.saveAll(Arrays.asList(car1,car2,car3));

		for (Car car : carRepo.findAll()) {
			logger.info(car.getBrand() + " " + car
					.getModel());
		}
	}
}
