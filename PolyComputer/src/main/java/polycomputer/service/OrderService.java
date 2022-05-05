package polycomputer.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.databind.JsonNode;

import polycomputer.entity.Order;

public interface OrderService {

	void deleteById(Long id);

	Order update(Order order);

	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findAll();

//	List<Order> selectTop10CustomerBuying();
	
	List<Order> selectTop10CustomerBoomHang();


	List<Order> finByTop5Username(String username);

	List<Order> finByUsername(String username);


	Page<Order> findByUsername(String username, Pageable pageable);

	List<Order> selectTheoProductBanRa();
	
	List<Order> selectDonHangChuaXacNhan();
	
	List<Order> selectDonHangThanhCong();
	
	List<Order> selectDoanhThuTheoNam();



	Order updateStatus(Long orderId);

	<S extends Order> S save(S entity);

}

