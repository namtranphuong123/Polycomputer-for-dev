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

import polycomputer.entity.BanPhim;
import polycomputer.entity.RAM;
import polycomputer.service.BanPhimService;
import polycomputer.service.RAMService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/rams")
public class RAMRestController {
	@Autowired
	RAMService ramService;
	
	@GetMapping()
	public List<RAM> getAll() {
		return ramService.findAll();
	}
	
	@GetMapping("{id}")
	public RAM getOne(@PathVariable("id") Integer id) {
		return ramService.findById(id);
	}
	
	@PostMapping()
	public RAM create(@RequestBody RAM RAM) {
		return ramService.create(RAM);
	}
	
	@PutMapping("{id}")
	public RAM update(@PathVariable("id") Integer id,
			@RequestBody RAM RAM) {
		return ramService.update(RAM);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		ramService.deleteById(id);
	}
	
//	@GetMapping("/search")
//	public List<RAM> search(ModelMap model ,
//			@RequestParam(name = "name", required = false)String name) {
//		List<RAM> list = null;
//		if(StringUtils.hasText(name)) {
//			list = ramService.findByRamNameContaining(name);
//			
//		}else {
//			list = ramService.findAll();
//			
//		}
//		return list;
//	}
}
