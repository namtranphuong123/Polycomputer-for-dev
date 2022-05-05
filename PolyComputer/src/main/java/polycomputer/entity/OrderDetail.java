package polycomputer.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name = "OrderDetails")
public class OrderDetail  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long orderDetailId;
	Double gia;
	Integer soLuong;
	Double tongTienSanPham;
	@ManyToOne
	@JoinColumn(name = "productId")
	Product productId;
	@ManyToOne
	@JoinColumn(name = "orderId")
	Order orderId;
}
