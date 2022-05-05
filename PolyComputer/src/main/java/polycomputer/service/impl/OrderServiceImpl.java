package polycomputer.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import polycomputer.dao.OrderDao;
import polycomputer.dao.OrderDetailDao;


import polycomputer.entity.Order;
import polycomputer.entity.OrderDetail;
import polycomputer.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao dao;
	@Autowired
	OrderDetailDao ddao;

	@Override
	public List<Order> findAll() {
		return dao.findAll();
	}
	


	@Override
	public <S extends Order> S save(S entity) {
		return dao.save(entity);
	}



	@Override
	public Order updateStatus(Long orderId) {
		return dao.updateStatus(orderId);
	}



	@Override
	public Order findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public Order update(Order order) {
		return dao.save(order);

	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		Order order = mapper.convertValue(orderData, Order.class);
		dao.save(order);
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
		};

		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type).stream()
				.peek(d -> d.setOrderId(order)).collect(Collectors.toList());
		ddao.saveAll(details);
		return order;
	}

//@Override
//public List<Order> selectTop10CustomerBuying() {
//	return dao.selectTop10CustomerBuying();
//}
	@Override
	public List<Order> selectTop10CustomerBoomHang() {
		return dao.selectTop10CustomerBoomHang();
	}

	@Override
	public List<Order> finByUsername(String username) {
		return dao.findByUsername(username);
	}

	@Override
	public List<Order> finByTop5Username(String username) {
		return dao.findByTop5Username(username);
	}


	@Override
	public Page<Order> findByUsername(String username, Pageable pageable) {
		return dao.findByUsername(username, pageable);
	}

	@Override
	public List<Order> selectTheoProductBanRa() {
		return dao.selectTheoProductBanRa();
	}

	@Override
	public List<Order> selectDonHangThanhCong() {
		return dao.selectDonHangThanhCong();
	}

	@Override
	public List<Order> selectDonHangChuaXacNhan() {
		return dao.selectDonHangChuaXacNhan();
	}

	@Override
	public List<Order> selectDoanhThuTheoNam() {
		return dao.selectDoanhThuTheoNam();
	}



	



	

}