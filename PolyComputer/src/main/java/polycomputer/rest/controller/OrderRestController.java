package polycomputer.rest.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.fasterxml.jackson.databind.JsonNode;

import polycomputer.entity.Order;
import polycomputer.service.OrderService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
	@Autowired
	OrderService orderService;
	
	@GetMapping()
	public List<Order> getAll() {
		return orderService.findAll();
	}
	@GetMapping("/Byuser")
	public List<Order> getByUser(HttpServletRequest request) {
        String username = request.getRemoteUser();

		return orderService.finByUsername(username);
	}
	
//	@GetMapping("top10CustomerBuying")
//	public List<Order> getTop10CustomerBuying() {
//		return orderService.selectTop10CustomerBuying();
//	}
	
	@GetMapping("/top10CustomerBoomHang")
	public List<Order> getTop10CustomerBoomHang() {
		return orderService.selectTop10CustomerBoomHang();
	}
	
//	@GetMapping("statisticalproduct")
//	public List<Order> statisticalProduct() {
//		return orderService.selectTheoProductBanRaCaiLoz();
//	}
	
	@GetMapping("/thanhcong")
	public List<Order> getThanhCong() {
		return orderService.selectDonHangThanhCong();
	}
	
	@GetMapping("/chuaxacnhan")
	public List<Order> getChuaXacNhan() {
		return orderService.selectDonHangChuaXacNhan();
	}
	
	@GetMapping("/doanhthutheonam")
	public List<Order> getDoanhThuTheoNam() {
		return orderService.selectDoanhThuTheoNam();
	}
	
	@GetMapping("{id}")
	public Order getOne(@PathVariable("id") Long id) {
		return orderService.findById(id);
	}
	
	@PostMapping()
	public Order create(@RequestBody JsonNode orderData) {
		return orderService.create(orderData);
	}
	
	@PutMapping("{id}")
	public Order update(@PathVariable("id") Long id,
			@RequestBody Order order) {
		return orderService.update(order);
	}
	@GetMapping("{id1}")
	public Order updateStatus(@PathVariable("id1") Long id) {
	
		return orderService.updateStatus(id);
	}
	
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		orderService.deleteById(id);
	}
}