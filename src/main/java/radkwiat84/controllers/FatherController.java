package radkwiat84.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import radkwiat84.model.Family;
import radkwiat84.model.Father;
import radkwiat84.repositories.FamilyRepository;
import radkwiat84.repositories.FatherRepository;

@Transactional
@RestController
@RequestMapping("/father")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class FatherController {

	@Autowired
	FatherRepository fatherRepository;
	
	@Autowired
	FamilyRepository familyRepository;
	

	@PostMapping("/father")
	public Father createFather(@RequestBody Father father) {
		return fatherRepository.save(father);
	}

	@GetMapping("/fathers")
	public List<Father> readFathers() {
		return fatherRepository.findAll();
	}

	@GetMapping("/father/{id}")
	public Father getFatherByFamilyId(@PathVariable int id) {
		return fatherRepository.findFatherByFamilyId(id);
	}

	@PutMapping("/father")
	public Father addFatherToFamily(@RequestBody Father father) {
		List<Family> families = familyRepository.findAll();
		father.setFamily(families.get(families.size()-1));
		return fatherRepository.save(father);
	}
}
