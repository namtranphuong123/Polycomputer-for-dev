package polycomputer.controller;

import java.io.IOException;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import antlr.StringUtils;
import polycomputer.entity.Account;
import polycomputer.entity.Order;
import polycomputer.entity.Product;
import polycomputer.entity.Status;
import polycomputer.service.OrderService;
import polycomputer.service.StatusService;


@Controller
@RequestMapping("/order")
public class OrderController {
		@Autowired
		OrderService orderService;
		@Autowired
		StatusService stt;
	
	@RequestMapping("/thanhtoan")
	public String checkout() {
		return "order/thanhtoan";
	}
//	@RequestMapping("/order/list")
//	public String list() {
//	
//		return "order/list";
//	}
//	@RequestMapping("/order/list")
//	public String list(Model model , HttpServletRequest request) {
//		String username = request.getRemoteUser();
//		model.addAttribute("orders",orderService.finByTop5Username(username));
//
//		return "order/list";
//	}
//	 
	@RequestMapping("/list")
	public String store() {
		return "redirect:/order/list/page?p=0";
	}
	// tìm kiếm theo tên & phân trang
    @RequestMapping(value = "/list/page")
    public String list(ModelMap model,   HttpServletRequest request,
            @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size
           ) {

        int currentPage = page.orElse(1);// trang hien tai
        int pageSize = size.orElse(5);// kich thuoc cua page
        Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        String username = request.getRemoteUser();
        Page<Order>  resultPage = orderService.findByUsername(username, pageable); 
        
        int totalPages = resultPage.getTotalPages();
        if (totalPages > 0) {
            int start = Math.max(1, currentPage - 2);
            int end = Math.min(currentPage + 2, totalPages);
            if (totalPages > 5	) {
                if (end == totalPages)
                    start = end - 5;
                else if (start == 1)
                    end = start + 5;
            }
            List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);

        }
        model.addAttribute("shop", "co");
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("orderPage", resultPage);
		
		 model.addAttribute("pitems", resultPage); 
		
		 System.out.println(resultPage);
		
        return "order/list";

    }
    
	
//	
	@RequestMapping("/detail/{orderId}")
	public String detail(@PathVariable("orderId") Long orderId , Model model) {
		model.addAttribute("order",orderService.findById(orderId));
		return "order/detail";
	}
//	
	@RequestMapping("/list/{orderId}")
	public String TTorder(@PathVariable("orderId") Long orderId , Model model) {
		
		model.addAttribute("order",orderService.findById(orderId));
		return "order/list";
	}
	
	
	
//	@GetMapping("/order/updateStatus")
//	public Order updateStatus(ModelMap model, @RequestParam("orderId") Optional<Long> orderId) {
//		 return orderService.updateStatus(orderId.get());
//
//	}
//	
	@RequestMapping("/{orderId}")
	public String updateStatus(Order order , @PathVariable("orderId") Long orderId , Long newStatus) throws Exception {
		order = orderService.findById(orderId);
		if(order != null ) {
			Status st = new Status();
			st.setStatusId(5);
		    order.setStatusId(st);
		    orderService.save(order);
		    
		}else {
			throw new Exception("Không tìm thấy đơn hàng này " + orderId);
		}
		return "redirect:/order/detail/{orderId}";
	
		
	}
	
	
//	@PostMapping("/saveOrUpdate")
//	// các enotion để kiểm tra dữ liệu nếu có lỗi xảy rsa return về addoredit
//	public String saveOrUpdate(  @ModelAttribute("order") Order order, BindingResult result
//			, HttpServletRequest request
//		) throws  IOException {		
//		orderService.save(order);		
//		return "redirect:/order/list";
//		
//	}
	

//	
}
