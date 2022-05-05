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

import polycomputer.entity.CongKetNoi;
import polycomputer.service.CongKetNoiService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/congketnois")
public class CongKetNoiRestController {
	@Autowired
	CongKetNoiService CongKetNoiService;
	
	@GetMapping()
	public List<CongKetNoi> getAll() {
		return CongKetNoiService.findAll();
	}
	
	@GetMapping("{id}")
	public CongKetNoi getOne(@PathVariable("id") Integer id) {
		return CongKetNoiService.findById(id);
	}
	
	@PostMapping()
	public CongKetNoi create(@RequestBody CongKetNoi CongKetNoi) {
		return CongKetNoiService.create(CongKetNoi);
	}
	
	@PutMapping("{id}")
	public CongKetNoi update(@PathVariable("id") Integer id,
			@RequestBody CongKetNoi CongKetNoi) {
		return CongKetNoiService.update(CongKetNoi);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		CongKetNoiService.deleteById(id);
	}
	
//	@GetMapping("/search")
//	public List<CongKetNoi> search(ModelMap model ,
//			@RequestParam(name = "name", required = false)String name) {
//		List<CongKetNoi> list = null;
//		if(StringUtils.hasText(name)) {
//			list = CongKetNoiService.findByCongKetNoiNameContaining(name);
//			
//		}else {
//			list = CongKetNoiService.findAll();
//			
//		}
//		return list;
//	}
}
