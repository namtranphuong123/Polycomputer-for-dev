package polycomputer.service;

import java.util.List;

import polycomputer.entity.OrderDetail;

public interface OrderDetailService {

	void deleteById(Long id);

	OrderDetail update(OrderDetail orderDetail);

	OrderDetail create(OrderDetail orderDetail);

	OrderDetail findById(Long id);

	List<OrderDetail> findAll();



}
