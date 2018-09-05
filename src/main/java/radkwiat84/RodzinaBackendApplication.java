package radkwiat84;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import radkwiat84.model.Family;
import radkwiat84.repositories.FamilyRepository;

@SpringBootApplication
public class RodzinaBackendApplication implements CommandLineRunner{

	@Autowired
	private FamilyRepository familyRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(RodzinaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		familyRepository.save(new Family());
		familyRepository.save(new Family());
		
	}
}
