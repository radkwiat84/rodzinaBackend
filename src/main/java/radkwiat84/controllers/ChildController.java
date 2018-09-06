package radkwiat84.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import radkwiat84.model.Child;
import radkwiat84.repositories.ChildRepository;

@Transactional
@RestController
@RequestMapping("/child")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*" )
public class ChildController {

	@Autowired
	ChildRepository childRepository;
	
	@PostMapping("/createChild")
	public Child createChild(@RequestBody Child child) {
		return childRepository.save(child);
	}
	
	
}
