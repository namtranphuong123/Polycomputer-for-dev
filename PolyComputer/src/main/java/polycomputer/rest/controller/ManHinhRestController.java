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

import polycomputer.entity.ManHinh;
import polycomputer.service.ManHinhService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/manhinhs")
public class ManHinhRestController {
	@Autowired
	ManHinhService ManHinhService;
	
	@GetMapping()
	public List<ManHinh> getAll() {
		return ManHinhService.findAll();
	}
	
	@GetMapping("{id}")
	public ManHinh getOne(@PathVariable("id") Integer id) {
		return ManHinhService.findById(id);
	}
	
	@PostMapping()
	public ManHinh create(@RequestBody ManHinh ManHinh) {
		return ManHinhService.create(ManHinh);
	}
	
	@PutMapping("{id}")
	public ManHinh update(@PathVariable("id") Integer id,
			@RequestBody ManHinh ManHinh) {
		return ManHinhService.update(ManHinh);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		ManHinhService.deleteById(id);
	}
	
//	@GetMapping("/search")
//	public List<ManHinh> search(ModelMap model ,
//			@RequestParam(name = "name", required = false)String name) {
//		List<ManHinh> list = null;
//		if(StringUtils.hasText(name)) {
//			list = ManHinhService.findByManHinhNameContaining(name);
//			
//		}else {
//			list = ManHinhService.findAll();
//			
//		}
//		return list;
//	}
}
