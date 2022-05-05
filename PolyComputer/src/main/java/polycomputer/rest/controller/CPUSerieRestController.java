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

import polycomputer.entity.CPUSerie;
import polycomputer.service.CPUSerieService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/cpuseries")
public class CPUSerieRestController {
	@Autowired
	CPUSerieService CPUSerieService;
	
	@GetMapping()
	public List<CPUSerie> getAll() {
		return CPUSerieService.findAll();
	}
	
	@GetMapping("{id}")
	public CPUSerie getOne(@PathVariable("id") Integer id) {
		return CPUSerieService.findById(id);
	}
	
	@PostMapping()
	public CPUSerie create(@RequestBody CPUSerie CPUSerie) {
		return CPUSerieService.create(CPUSerie);
	}
	
	@PutMapping("{id}")
	public CPUSerie update(@PathVariable("id") Integer id,
			@RequestBody CPUSerie CPUSerie) {
		return CPUSerieService.update(CPUSerie);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		CPUSerieService.deleteById(id);
	}
	
//	@GetMapping("/search")
//	public List<CPUSerie> search(ModelMap model ,
//			@RequestParam(name = "name", required = false)String name) {
//		List<CPUSerie> list = null;
//		if(StringUtils.hasText(name)) {
//			list = CPUSerieService.findByCpuSerieNameContaining(name);
//			
//		}else {
//			list = CPUSerieService.findAll();
//			
//		}
//		return list;
//	}
}
