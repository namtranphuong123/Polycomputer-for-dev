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

import polycomputer.entity.LuuTru;
import polycomputer.service.LuuTruService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/luutrus")
public class LuuTruRestController {
	@Autowired
	LuuTruService LuuTruService;
	
	@GetMapping()
	public List<LuuTru> getAll() {
		return LuuTruService.findAll();
	}
	
	@GetMapping("{id}")
	public LuuTru getOne(@PathVariable("id") Integer id) {
		return LuuTruService.findById(id);
	}
	
	@PostMapping()
	public LuuTru create(@RequestBody LuuTru LuuTru) {
		return LuuTruService.create(LuuTru);
	}
	
	@PutMapping("{id}")
	public LuuTru update(@PathVariable("id") Integer id,
			@RequestBody LuuTru LuuTru) {
		return LuuTruService.update(LuuTru);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		LuuTruService.deleteById(id);
	}
	
//	@GetMapping("/search")
//	public List<LuuTru> search(ModelMap model ,
//			@RequestParam(name = "name", required = false)String name) {
//		List<LuuTru> list = null;
//		if(StringUtils.hasText(name)) {
//			list = LuuTruService.findByLuuTruNameContaining(name);
//			
//		}else {
//			list = LuuTruService.findAll();
//			
//		}
//		return list;
//	}
}
