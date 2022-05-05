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

import polycomputer.entity.Color;
import polycomputer.service.ColorService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/colors")
public class ColorRestController {
	@Autowired
	ColorService ColorService;
	
	@GetMapping()
	public List<Color> getAll() {
		return ColorService.findAll();
	}
	
	@GetMapping("{id}")
	public Color getOne(@PathVariable("id") Integer id) {
		return ColorService.findById(id);
	}
	
	@PostMapping()
	public Color create(@RequestBody Color Color) {
		return ColorService.create(Color);
	}
	
	@PutMapping("{id}")
	public Color update(@PathVariable("id") Integer id,
			@RequestBody Color Color) {
		return ColorService.update(Color);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		ColorService.deleteById(id);
	}
//	
//	@GetMapping("/search")
//	public List<Color> search(ModelMap model ,
//			@RequestParam(name = "name", required = false)String name) {
//		List<Color> list = null;
//		if(StringUtils.hasText(name)) {
//			list = ColorService.findByColorNameContaining(name);
//			
//		}else {
//			list = ColorService.findAll();
//			
//		}
//		return list;
//	}
}
