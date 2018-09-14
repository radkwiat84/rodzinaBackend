package radkwiat84.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.text.AsyncBoxView.ChildState;
import javax.transaction.Transactional;

import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
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
	public List<Child> readChildrenWithoutFamily() {
		return childRepository.findByFamilyIdIsNull();
	}

	@GetMapping("/childrenWithFamily")
	public List<Child> getChildrenWithFamily() {
		return childRepository.findByFamilyIdIsNotNull();
	}

	@PutMapping("/child")
	public Child addChildToFamily(@RequestBody Child child) {
		List<Family> families = familyRepository.findAll();
		child.setFamily(families.get(families.size() - 1));
		return childRepository.save(child);
	}

	@GetMapping("/childrenFamilyId/{id}")
	public List<Integer> getChildrenIdByFamilyId(@PathVariable int id) {
		List<Integer> childrenId = new ArrayList<>();
		List<Child> children = childRepository.findAllByFamilyId(id);
		for (Child child : children) {
			int idOfChild = child.getId();
			childrenId.add(idOfChild);
		}
		return childrenId;
	}

	@GetMapping("/childById/{id}")
	public Optional<Child> getChildById(@PathVariable int id) {
		return childRepository.findById(id);
	}

	@GetMapping("/searchingChildren/{firstName}/{secondName}/{pesel}/{birthDate}/{sex}")
	public List<Child> findChildrenFromSearchEngine(@PathVariable String firstName, @PathVariable String secondName,
			@PathVariable String pesel, @PathVariable String birthDate, @PathVariable String sex) {
		return childRepository.findAllByQuery(firstName, secondName, pesel, birthDate, sex);

	}

}
