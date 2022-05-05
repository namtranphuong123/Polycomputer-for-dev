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
import polycomputer.entity.SoCongLuuTruToiDa;
import polycomputer.service.BanPhimService;
import polycomputer.service.SoCongLuuTruToiDaService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/socongluutrutoidas")
public class SoCongLuuTruToiDaRestController {
	@Autowired
	SoCongLuuTruToiDaService soCongLuuTruToiDaService;
	
	@GetMapping()
	public List<SoCongLuuTruToiDa> getAll() {
		return soCongLuuTruToiDaService.findAll();
	}
	
	@GetMapping("{id}")
	public SoCongLuuTruToiDa getOne(@PathVariable("id") Integer id) {
		return soCongLuuTruToiDaService.findById(id);
	}
	
	@PostMapping()
	public SoCongLuuTruToiDa create(@RequestBody SoCongLuuTruToiDa soCongLuuTruToiDa) {
		return soCongLuuTruToiDaService.create(soCongLuuTruToiDa);
	}
	
	@PutMapping("{id}")
	public SoCongLuuTruToiDa update(@PathVariable("id") Integer id,
			@RequestBody SoCongLuuTruToiDa soCongLuuTruToiDa) {
		return soCongLuuTruToiDaService.update(soCongLuuTruToiDa);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		soCongLuuTruToiDaService.deleteById(id);
	}
	
//	@GetMapping("/search")
//	public List<SoCongLuuTruToiDa> search(ModelMap model ,
//			@RequestParam(name = "name", required = false)String name) {
//		List<SoCongLuuTruToiDa> list = null;
//		if(StringUtils.hasText(name)) {
//			list = soCongLuuTruToiDaService.findBySoCongLuuTruToiDaNameContaining(name);
//			
//		}else {
//			list = soCongLuuTruToiDaService.findAll();
//			
//		}
//		return list;
//	}
}
