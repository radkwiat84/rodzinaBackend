package radkwiat84.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import radkwiat84.model.Father;
import radkwiat84.repositories.FatherRepository;

@RestController
@RequestMapping("/father")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class FatherController {

	@Autowired
	FatherRepository fatherRepository;
	
	@PostMapping("/createFather")
	public Father createFather(@RequestBody Father father) {
		return fatherRepository.save(father);
	}
	
	@GetMapping("/fathers")
	public List<Father> readFathers(){
		return fatherRepository.findAll();
	}
	
	@GetMapping("/father/{id}")
	public Father getFatherByFamilyId(@PathVariable int id) {
		return fatherRepository.findFatherByFamilyId(id);
	}
	
}
