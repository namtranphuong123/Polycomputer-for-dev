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

import polycomputer.entity.PhuKienDiKem;
import polycomputer.service.PhuKienDiKemService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/phukiendikems")
public class PhuKienDiKemRestController {
	@Autowired
	PhuKienDiKemService phuKienDiKemService;
	
	@GetMapping()
	public List<PhuKienDiKem> getAll() {
		return phuKienDiKemService.findAll();
	}
	
	@GetMapping("{id}")
	public PhuKienDiKem getOne(@PathVariable("id") Integer id) {
		return phuKienDiKemService.findById(id);
	}
	
	@PostMapping()
	public PhuKienDiKem create(@RequestBody PhuKienDiKem phuKienDiKem) {
		return phuKienDiKemService.create(phuKienDiKem);
	}
	
	@PutMapping("{id}")
	public PhuKienDiKem update(@PathVariable("id") Integer id,
			@RequestBody PhuKienDiKem phuKienDiKem) {
		return phuKienDiKemService.update(phuKienDiKem);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		phuKienDiKemService.deleteById(id);
	}
	
//	@GetMapping("/search")
//	public List<PhuKienDiKem> search(ModelMap model ,
//			@RequestParam(name = "name", required = false)String name) {
//		List<PhuKienDiKem> list = null;
//		if(StringUtils.hasText(name)) {
//			list = phuKienDiKemService.findByPhuKienDiKemNameContaining(name);
//			
//		}else {
//			list = phuKienDiKemService.findAll();
//			
//		}
//		return list;
//	}
}
