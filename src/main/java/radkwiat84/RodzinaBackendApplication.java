package radkwiat84;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import radkwiat84.model.Father;
import radkwiat84.repositories.FatherRepository;



@SpringBootApplication
public class RodzinaBackendApplication implements CommandLineRunner{
	
	@Autowired
	FatherRepository fatherRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(RodzinaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fatherRepository.save(new Father("tata", "moj", "2014-12-12", "moja"));
	}


	
}
