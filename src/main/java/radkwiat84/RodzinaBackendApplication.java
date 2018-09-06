package radkwiat84;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import radkwiat84.repositories.FatherRepository;



@SpringBootApplication
public class RodzinaBackendApplication{
	
	@Autowired
	FatherRepository fatherRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(RodzinaBackendApplication.class, args);
	}



	
}
