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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import polycomputer.entity.Gift;
import polycomputer.service.GiftService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/gifts")
public class GiftRestController {
	@Autowired
	GiftService GiftService;
	
	@GetMapping()
	public List<Gift> getAll() {
		return GiftService.findAll();
	}
	
	@GetMapping("{id}")
	public Gift getOne(@PathVariable("id") Integer id) {
		return GiftService.findById(id);
	}
	
	@PostMapping()
	public Gift create(@RequestBody Gift Gift) {
		return GiftService.create(Gift);
	}
	
	@PutMapping("{id}")
	public Gift update(@PathVariable("id") Integer id,
			@RequestBody Gift Gift) {
		return GiftService.update(Gift);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		GiftService.deleteById(id);
	}
	
//	@GetMapping("/search")
//	public List<Gift> search(ModelMap model ,
//			@RequestParam(name = "name", required = false)String name) {
//		List<Gift> list = null;
//		if(StringUtils.hasText(name)) {
//			list = GiftService.findByGiftNameContaining(name);
//			
//		}else {
//			list = GiftService.findAll();
//			
//		}
//		return list;
//	}
}
