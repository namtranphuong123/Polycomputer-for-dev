package polycomputer.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import polycomputer.entity.Account;
import polycomputer.entity.Brand;
import polycomputer.entity.Product;
import polycomputer.service.AccountService;

@Controller
@RequestMapping("/account")
public class accountController {
	@Autowired
	AccountService accountService;
	@RequestMapping("")
	public String dangky() {
		return "/account/form";
	}
	@GetMapping("/details")
	public String detail(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		Account item = accountService.findById(username);
		model.addAttribute("item", item);
		
		return "account/detail";
	}
	
	@PostMapping("/saveOrUpdate")
	// các enotion để kiểm tra dữ liệu nếu có lỗi xảy rsa return về addoredit
	public String saveOrUpdate(  @ModelAttribute("item") Account account, BindingResult result
			, HttpServletRequest request
		) throws  IOException {
		String username = request.getRemoteUser();
		Account item = accountService.findById(username);
	account.setPassword(item.getPassword());
		accountService.save(account);
		
	
		return "redirect:/account/details";
		
	}
	
	
	
	
	
	
//	@RequestMapping("/account/{username}")
//		public String updateAccount(  @ModelAttribute("item")  Account account , @PathVariable("username") String username ) throws Exception {
//		Optional<Account> opt =  accountService.findByUsername(username);
//			if(opt != null ) {
//				Account entity = opt.get();
//				BeanUtils.copyProperties(entity, account);
//			    accountService.save(account);
//			    
//			}else {
//				throw new Exception("Không tìm thấy tài khoản  này " + username);
//			}
//			return "redirect:/account/details";
//		
//			
//		}
    
	
	
	
	
}
