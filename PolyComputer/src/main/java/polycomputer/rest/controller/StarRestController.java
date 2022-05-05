package polycomputer.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import polycomputer.entity.Star;
import polycomputer.service.StarService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/stars")
public class StarRestController {
	@Autowired
	StarService starService;
	
	@GetMapping()
	public List<Star> getAll() {
		return starService.findAll();
	}
	
}
