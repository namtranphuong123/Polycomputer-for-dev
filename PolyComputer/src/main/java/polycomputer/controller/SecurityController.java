package polycomputer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import polycomputer.service.AccountService;

@Controller
public class SecurityController {
	@Autowired
	private HttpSession session;
	@RequestMapping("/security/login/form")
public String loginForm(Model model) {
	model.addAttribute("message","Vui Lòng Đăng Nhập!");
	return "security/login";
	
}
	
	@RequestMapping("/security/login/success")
	public String loginSuccess(Model model) {
			model.addAttribute("message","Đăng nhập thành công !");
			Object ruri = session.getAttribute("redirect-uri");

			if (ruri != null) {
				session.removeAttribute("redirect-uri");
				return ("redirect:" + ruri);
			}
			// vaf trar ve trang minh muon
			return "redirect:/product/trangchu";
		
	}

	
	@RequestMapping("/security/login/error")
	public String loginError(Model model) {
		model.addAttribute("message","Sai Thông Tin Đăng nhập !");
		return "security/login";
		
	}
	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model model) {
			model.addAttribute("message","Không Có Quyền truy xuất !");
		return "security/login";
		
	}
	@RequestMapping("/security/logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message", "Bạn đã đăng xuất !");
		return "redirect:/product/trangchu";
		
	}
	@RequestMapping("/security/login/success2")
	public String loginSuccess2(Model model) {
			model.addAttribute("message","Đăng nhập thành công !");
			return "security/login";
		
	}
	@Autowired
	AccountService acc;
	@RequestMapping("/security2/login/success")
	public String successDk(OAuth2AuthenticationToken oauth2) {
		acc.loginFromOAuth2(oauth2);
		Object ruri = session.getAttribute("redirect-uri");

		if (ruri != null) {
			session.removeAttribute("redirect-uri");
			return ("redirect:" + ruri);
		}
		return"forward:/security/login/success";
	}
	
	
}
