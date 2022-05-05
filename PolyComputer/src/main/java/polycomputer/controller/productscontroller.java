package polycomputer.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

import polycomputer.entity.Brand;
import polycomputer.entity.Category;
import polycomputer.entity.Images;
import polycomputer.entity.Product;
import polycomputer.service.BrandService;
import polycomputer.service.CategoryService;
import polycomputer.service.ImageService;
import polycomputer.service.ProductService;

@Controller
public class productscontroller {
	@Autowired
	ProductService productService;
	@Autowired
	BrandService brandService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ImageService img;


	@RequestMapping("product/brand")
	public String listbrand(Model model, @RequestParam("cid") Optional<Integer> cid) {
		if (cid.isPresent()) {
			List<Object[]> top3banchaycuahang = productService.top3ProducthotoderofBrand(cid.get());
			  model.addAttribute("top3banchaycuahang", top3banchaycuahang);
			List<Product> list = productService.findByBrandId(cid.get());
			model.addAttribute("items1", list);
//			List<Product> top3noibat = productService.findAll();
//			model.addAttribute("items1", top3noibat);
			List<Product> top4moinhat = productService.top10newforBrand(cid.get());
			model.addAttribute("items4new", top4moinhat);
		

		}

		return "brand/sanphamtheohang";
	}

	
	@RequestMapping("product/trangchu")
	public String list(Model model) {

		List<Brand> brand = brandService.findAll();
		model.addAttribute("brand", brand);

		  List<Object[]> top10banchay = productService.top10HotOrder();
		  model.addAttribute("top10banchay", top10banchay);
		  List<Product> top5khuyen = productService.top5khuyen();

			model.addAttribute("top5k", top5khuyen);
		List<Product> top10new = productService.top10new();

		model.addAttribute("top10moinhat", top10new);

		return "product/trangchu";
	}

	@RequestMapping("/product/details/{productId}")
	public String detail(Model model, @PathVariable("productId") Integer productId) {
		Product item1 = productService.findById(productId);
		model.addAttribute("item", item1);

		List<Images> item = img.findByProductId(productId);
		model.addAttribute("item1", item);

		List<Brand> brand = brandService.findAll();
		model.addAttribute("brand", brand);
		return "product/details";
	}

	@RequestMapping("/error/error")
	public String error() {

		return "error/error";
	}

}
