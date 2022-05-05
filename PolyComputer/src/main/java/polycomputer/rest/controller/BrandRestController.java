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

import polycomputer.entity.Brand;
import polycomputer.service.BrandService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/brands")
public class BrandRestController {
	@Autowired
	BrandService brandService;
	
	@GetMapping()
	public List<Brand> getAll() {
		return brandService.findAll();
	}
	
	@GetMapping("{id}")
	public Brand getOne(@PathVariable("id") Integer id) {
		return brandService.findById(id);
	}
	
	@PostMapping()
	public Brand create(@RequestBody Brand brand) {
		return brandService.create(brand);
	}
	
	@PutMapping("{id}")
	public Brand update(@PathVariable("id") Integer id,
			@RequestBody Brand brand) {
		return brandService.update(brand);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		brandService.deleteById(id);
	}
	
//	@GetMapping("/search")
//	public List<Brand> search(ModelMap model ,
//			@RequestParam(name = "name", required = false)String name) {
//		List<Brand> list = null;
//		if(StringUtils.hasText(name)) {
//			list = brandService.findByBrandNameContaining(name);
//			
//		}else {
//			list = brandService.findAll();
//			
//		}
//		return list;
//	}
}
