package polycomputer.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity @Table(name = "products")
public class Product  implements Serializable{
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer productId;
	String productName;
	String anhChinh;
	String anhPhu1;
	String anhPhu2;
	String anhPhu3;
	String anhPhu4;
	Double gia;
	Double khoiLuong;
	Integer soLuong;
	Integer giamGia;
	Integer baoHanh;
	String kichThuoc;
	String productSlug;
	String description;
	@Temporal(TemporalType.DATE)
	@Column(name = "created_At")
	Date createdAt = new Date();	
	@Temporal(TemporalType.DATE)
	@Column(name = "updated_At")
	Date updatedAt = new Date();
	
	Boolean Available;
	@ManyToOne
	@JoinColumn(name = "categoryId")
	Category category;
	@ManyToOne
	@JoinColumn(name = "brandId")
	Brand brand;
	@ManyToOne
	@JoinColumn(name = "cpuId")
	CPU cpu;
	@ManyToOne
	@JoinColumn(name = "cpuSerieId")
	CPUSerie cpuSerie;
	@ManyToOne
	@JoinColumn(name = "colorId")
	Color color;
	@ManyToOne
	@JoinColumn(name = "chipDoHoaId")
	ChipDoHoa chipDoHoa;
	@ManyToOne
	@JoinColumn(name = "manHinhId")
	ManHinh manHinh;
	@ManyToOne
	@JoinColumn(name = "ramId")
	RAM ram;
	@ManyToOne
	@JoinColumn(name = "luuTruId")
	LuuTru luuTru;
	@ManyToOne
	@JoinColumn(name = "soCongLuuTruToiDaId")
	SoCongLuuTruToiDa soCongLuuTruToiDa;
	@ManyToOne
	@JoinColumn(name = "congXuatHinhId")
	CongXuatHinh congXuatHinh;
	@ManyToOne
	@JoinColumn(name = "congKetNoiId")
	CongKetNoi congKetNoi;
	@ManyToOne
	@JoinColumn(name = "banPhimId")
	BanPhim banPhim;
	@ManyToOne
	@JoinColumn(name = "heDieuHanhId")
	HeDieuHanh heDieuHanh;
	@ManyToOne
	@JoinColumn(name = "pinId")
	Pin pin;
	@ManyToOne
	@JoinColumn(name = "giftId")
	Gift gift;
	@ManyToOne
	@JoinColumn(name = "phuKienDiKemId")
	PhuKienDiKem phuKienDiKem;
	@JsonIgnore
	@OneToMany(mappedBy = "productId")
	List<OrderDetail> orderDetails;	
	
	@JsonIgnore
	@OneToMany(mappedBy = "productId")
	List<Images> images;	
	
	@JsonIgnore
	@OneToMany(mappedBy = "ratingId")//1 thg co nhieu binh luan
	List<Rating> ratings;
}