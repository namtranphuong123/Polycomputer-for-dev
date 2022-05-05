package polycomputer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class shoppingCartController {
	@RequestMapping("/cart/view")
public String view() {
	return "cart/cart";
}
}
