package polycomputer.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import polycomputer.entity.Rating;
import polycomputer.service.RatingService;




@CrossOrigin("*")
@RestController
@RequestMapping("/rest/binhluans")
public class RatingRestController {
	@Autowired
	RatingService RatingService;
	
	@GetMapping()
	public List<Rating> getAll() {
		return RatingService.findAll();
	}
	
	@GetMapping("{id}")
	public Rating getOne(@PathVariable("id") Integer id) {
		return RatingService.findById(id);
	}
	
	@PostMapping()
	public Rating create(@RequestBody Rating Rating) {
		return RatingService.create(Rating);
	}
	
	@PutMapping("{id}")
	public Rating update(@PathVariable("id") Integer id,
			@RequestBody Rating Rating) {
		return RatingService.update(Rating);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		RatingService.deleteById(id);
	}
}
