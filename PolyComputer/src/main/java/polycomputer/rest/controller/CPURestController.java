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

import polycomputer.entity.CPU;
import polycomputer.service.CPUService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/cpus")
public class CPURestController {
	@Autowired
	CPUService CPUService;
	
	@GetMapping()
	public List<CPU> getAll() {
		return CPUService.findAll();
	}
	
	@GetMapping("{id}")
	public CPU getOne(@PathVariable("id") Integer id) {
		return CPUService.findById(id);
	}
	
	@PostMapping()
	public CPU create(@RequestBody CPU CPU) {
		return CPUService.create(CPU);
	}
	
	@PutMapping("{id}")
	public CPU update(@PathVariable("id") Integer id,
			@RequestBody CPU CPU) {
		return CPUService.update(CPU);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		CPUService.deleteById(id);
	}
	
//	@GetMapping("/search")
//	public List<CPU> search(ModelMap model ,
//			@RequestParam(name = "name", required = false)String name) {
//		List<CPU> list = null;
//		if(StringUtils.hasText(name)) {
//			list = CPUService.findByCpuNameContaining(name);
//			
//		}else {
//			list = CPUService.findAll();
//			
//		}
//		return list;
//	}
}
