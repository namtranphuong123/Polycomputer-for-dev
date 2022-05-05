package polycomputer.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import polycomputer.entity.Order;
import polycomputer.entity.Product;
import polycomputer.service.OrderService;
import polycomputer.service.ProductService;


@Controller
public class AllProducts {
	@Autowired
	ProductService productService;
	@RequestMapping("/product/allproduct")
public String list(Model model
		,@RequestParam("cid")Optional<Integer> cid
		,@RequestParam("cat")Optional<Integer> cat
		,@RequestParam("col")Optional<Integer> col
		,@RequestParam("cpu")Optional<Integer> cpu
		,@RequestParam("chipdh")Optional<Integer> chipdh
		,@RequestParam("ram")Optional<Integer> ram) {
		
		
		
		if( cid.isPresent() && cat.isPresent() && col.isPresent() && cpu.isPresent()
				&& chipdh.isPresent() && ram.isPresent() ) {
			List<Product> list = productService.findByAll(cid.get(), cat.get(), col.get(), cpu.get(), chipdh.get(), ram.get());
			model.addAttribute("all",list);
			}
		else if(cat.isPresent()) {
			List<Product> list = productService.findByCategoryId(cat.get());
			model.addAttribute("all",list);
			}
		 else if (col.isPresent()) {
			List<Product> list = productService.findByColorId(col.get());
			model.addAttribute("all",list);
			}
		 else if (cid.isPresent()) {
				List<Product> list = productService.findByBrandId(cid.get());
				model.addAttribute("all",list);
				}
		 else if (cpu.isPresent()) {
				List<Product> list = productService.findByCpuId(cpu.get());
				model.addAttribute("all",list);
				}
		 else if (chipdh.isPresent()) {
				List<Product> list = productService.findByChipdohoaId(chipdh.get());
				model.addAttribute("all",list);
				}
		 else if (ram.isPresent()) {
				List<Product> list = productService.findByRamId(ram.get());
				model.addAttribute("all",list);
				}
		else {
			
			List<Product> list1 = productService.findAll();
			model.addAttribute("all",list1);
		
			
		}
		
		return "product/allproduct";
}
	
	@RequestMapping("/product/all/search")
	public String search(ModelMap model ,
			@RequestParam(name = "name", required = false)String name) {
		List<Product> list = null;
		if(StringUtils.hasText(name)) {
			list = productService.findByProductNameContaining(name);
			
		}else {
			list = productService.findAll();
			
		}
		model.addAttribute("all",list);
		return "product/allproduct";
	}
}
