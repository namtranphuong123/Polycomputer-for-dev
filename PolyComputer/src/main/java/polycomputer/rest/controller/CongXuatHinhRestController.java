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

import polycomputer.entity.CongXuatHinh;
import polycomputer.service.CongXuatHinhService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/congxuathinhs")
public class CongXuatHinhRestController {
	@Autowired
	CongXuatHinhService CongXuatHinhService;
	
	@GetMapping()
	public List<CongXuatHinh> getAll() {
		return CongXuatHinhService.findAll();
	}
	
	@GetMapping("{id}")
	public CongXuatHinh getOne(@PathVariable("id") Integer id) {
		return CongXuatHinhService.findById(id);
	}
	
	@PostMapping()
	public CongXuatHinh create(@RequestBody CongXuatHinh CongXuatHinh) {
		return CongXuatHinhService.create(CongXuatHinh);
	}
	
	@PutMapping("{id}")
	public CongXuatHinh update(@PathVariable("id") Integer id,
			@RequestBody CongXuatHinh CongXuatHinh) {
		return CongXuatHinhService.update(CongXuatHinh);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		CongXuatHinhService.deleteById(id);
	}
	
//	@GetMapping("/search")
//	public List<CongXuatHinh> search(ModelMap model ,
//			@RequestParam(name = "name", required = false)String name) {
//		List<CongXuatHinh> list = null;
//		if(StringUtils.hasText(name)) {
//			list = CongXuatHinhService.findByCongXuatHinhNameContaining(name);
//			
//		}else {
//			list = CongXuatHinhService.findAll();
//			
//		}
//		return list;
//	}
}
