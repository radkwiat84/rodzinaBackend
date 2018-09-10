package radkwiat84.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import radkwiat84.model.Family;
import radkwiat84.repositories.FamilyRepository;

@RestController
@Transactional
@RequestMapping("/family")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class FamilyController {

	@Autowired
	FamilyRepository familyRepository;
	
	@PostMapping("/createfamily")
	public Family createFamily(@RequestBody Family family) {
		return familyRepository.save(family);
	}
	
	@GetMapping("/families")
	public List<Family> readFamiles(){
		return familyRepository.findAll();
	}
	
	@GetMapping("/family/{id}")
	public Optional<Family> readFamily( @PathVariable Integer id) {
		return familyRepository.findById(id);
	}
}
