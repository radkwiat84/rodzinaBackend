package radkwiat84.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import radkwiat84.model.Child;
import radkwiat84.model.Family;
import radkwiat84.repositories.ChildRepository;
import radkwiat84.repositories.FamilyRepository;

@Transactional
@RestController
@RequestMapping("/child")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class ChildController {

	@Autowired
	ChildRepository childRepository;
	
	@Autowired
	FamilyRepository familyRepository;
	
	@PostMapping("/child")
	public Child createChild(@RequestBody Child child) {
		return childRepository.save(child);
	}
	
	@GetMapping("/children")
	public List<Child> readChildren(){
		return childRepository.findByFamilyIdIsNull();
	}
	
	@PutMapping("/child")
	public Child addChildToFamily(@RequestBody Child child) {
		List<Family> families = familyRepository.findAll();
		child.setFamily(families.get(families.size()-1));
		return childRepository.save(child);
	}
	
	
	
	
}
