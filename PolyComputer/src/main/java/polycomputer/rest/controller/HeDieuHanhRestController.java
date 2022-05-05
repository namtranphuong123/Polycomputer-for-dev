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

import polycomputer.entity.HeDieuHanh;
import polycomputer.service.HeDieuHanhService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/hedieuhanhs")
public class HeDieuHanhRestController {
	@Autowired
	HeDieuHanhService HeDieuHanhService;
	
	@GetMapping()
	public List<HeDieuHanh> getAll() {
		return HeDieuHanhService.findAll();
	}
	
	@GetMapping("{id}")
	public HeDieuHanh getOne(@PathVariable("id") Integer id) {
		return HeDieuHanhService.findById(id);
	}
	
	@PostMapping()
	public HeDieuHanh create(@RequestBody HeDieuHanh HeDieuHanh) {
		return HeDieuHanhService.create(HeDieuHanh);
	}
	
	@PutMapping("{id}")
	public HeDieuHanh update(@PathVariable("id") Integer id,
			@RequestBody HeDieuHanh HeDieuHanh) {
		return HeDieuHanhService.update(HeDieuHanh);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		HeDieuHanhService.deleteById(id);
	}
	
//	@GetMapping("/search")
//	public List<HeDieuHanh> search(ModelMap model ,
//			@RequestParam(name = "name", required = false)String name) {
//		List<HeDieuHanh> list = null;
//		if(StringUtils.hasText(name)) {
//			list = HeDieuHanhService.findByHeDieuHanhNameContaining(name);
//			
//		}else {
//			list = HeDieuHanhService.findAll();
//			
//		}
//		return list;
//	}
}
