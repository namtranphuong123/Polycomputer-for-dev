

package polycomputer.dao;


import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import polycomputer.entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Long>{
//	@Query("SELECT TOP(10)  , c.full_name, o.username, count(o.order_id) as 'sodonhang', sum(o.tong_tien_thanh_toan) as 'tongtien'\r\n"
//			+ "FROM orders o \r\n"
//			+ "inner join customers c \r\n"
//			+ "on c.username = o.username\r\n"
//			+ "group by c.full_name,o.username\r\n"
//			+ "order by count(o.order_id) DESC")
//	List<Order> selectTop10CustomerBuying();
	
//	@Query("SELECT TOP(10)  c.full_name, o.username, sum(o.tong_tien_thanh_toan) as 'tongtienboom', sum(o.order_id) as 'solanboom'\r\n"
//			+ "FROM orders o \r\n"
//			+ "inner join customers c \r\n"
//			+ "on c.username = o.username\r\n"
//			+ "group by c.full_name, o.username\r\n"
//			+ "order by sum(o.tong_tien_thanh_toan),sum(o.order_id) DESC")
//	List<Order> selectTop10CustomerBoomHang();
	
	@Query(value="SELECT o from Order o where o.status=3", nativeQuery = true)
	List<Order> selectTop10CustomerBoomHang();
	
//	@Query(value = "select top 5 orders.user_id, accounts.name as 'Ten', COUNT(orders.orderid) as 'Tong so don', sum(orders.amount) as 'Tong tien'\r\n"
//			+ "from orders\r\n" + "join accounts on accounts.email = orders.user_id\r\n"
//			+ "where orders.status = 4\r\n" + "group by orders.user_id,accounts.name \r\n"
//			+ "order by COUNT(accounts.email) desc", nativeQuery = true)
//	List<Object[]> top5buyer();
	@Query("SELECT o FROM Order o WHERE o.account.username=?1")
	List<Order> findByUsername(String username);

	@Query(value ="select  * from orders o  where o.username =?1 order by created_at desc", nativeQuery = true)
	List<Order> findByTop5Username(String username);
	
	@Query("SELECT o FROM Order o WHERE o.account.username=?1")
	 Page<Order> findByUsername(String username, Pageable pageable);
	
//	 count(o.order_id) as 'sodonhang', sum(o.tong_tien_thanh_toan) as 'tongtien'
	@Query(value="SELECT o.username, COUNT(o.order_id), SUM(o.tong_tien_thanh_toan)\r\n"
			+ "FROM orders o \r\n"
			+ "GROUP BY o.username\r\n"
			+ "ORDER BY COUNT(o.order_id),SUM(o.tong_tien_thanh_toan) DESC", nativeQuery = true)
	List<Order> selectTheoProductBanRa();
	
	@Query(value="SELECT TOP(10) * FROM orders WHERE status = 4", nativeQuery = true)
	List<Order> selectDonHangThanhCong();
	@Query(value="SELECT * FROM orders WHERE status = 1", nativeQuery = true)
	List<Order> selectDonHangChuaXacNhan();

	@Query(value="Select YEAR(created_at) from orders GROUP BY YEAR(created_at)  order by YEAR(created_at)", nativeQuery = true)
	List<Order> selectDoanhThuTheoNam();
	
	
	@Query(value="update orders\r\n"
			+ "set status_id = 5\r\n"
			+ "where order_id = ?1", nativeQuery = true)
	     Order updateStatus(Long orderId );
}