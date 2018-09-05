package radkwiat84.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import radkwiat84.model.Family;
import radkwiat84.repositories.FamilyRepository;

@RestController
@Transactional
@RequestMapping("/family")
public class FamilyController {

	@Autowired
	FamilyRepository familyRepository;
	
	@PostMapping("/newfamily")
	public Family createFamily(Family family) {
		return familyRepository.save(family);
	}
	
	@GetMapping("/families")
	public List<Family> readFamiles(){
		return familyRepository.findAll();
	}
	
	@GetMapping("family/{id}")
	public Family readFamily(@PathVariable Integer id) {
		return familyRepository.getOne(id);
	}
}
