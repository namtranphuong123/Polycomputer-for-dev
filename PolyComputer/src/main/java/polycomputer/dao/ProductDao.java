package polycomputer.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import polycomputer.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p WHERE p.category.categoryId=?1")
	List<Product> findByCategoryId(Integer cat);
	@Query("SELECT p FROM Product p WHERE p.color.colorId=?1")
	List<Product> findByColorId(Integer col);
	@Query("SELECT p FROM Product p WHERE p.cpu.cpuId=?1")
	List<Product> findByCpuId(Integer cpu);
	@Query("SELECT p FROM Product p WHERE p.chipDoHoa.chipDoHoaId=?1")
	List<Product> findByChipdohoaId(Integer chipdh);
	@Query("SELECT p FROM Product p WHERE p.ram.ramId=?1")
	List<Product> findByRamId(Integer ram);
	
	@Query("SELECT p FROM Product p WHERE p.brand.brandId=?1")
	List<Product> findByBrandId(Integer cid);
	
	@Query(value = "select * from  products where  brand_id = ?1 and category_id = ?2 and color_id = ?3 and cpu_id = ?4 and chip_do_hoa_id = ?5 and ram_id = ?6", nativeQuery = true)
	List<Product> findByAll(Integer cid  ,Integer cat,Integer col,Integer cpu,Integer chipdh,Integer ram);
	
	@Query(value ="select  * from products order by gia desc", nativeQuery = true)
	List<Product> giagiamdan();
	@Query(value ="select  * from products order by gia asc", nativeQuery = true)
	List<Product> giatangdan();
	
	//List<Product> findByProductNameContaining(String name);
	
	
//	Page<Product> findByProductNameContaining(String name,Pageable pageable);
	 Page<Product> findByProductNameContaining(String name, Pageable pageable); 	
		@Query(value = "select top 5 * from products where giam_gia > 0", nativeQuery = true)
		List<Product> top5khuyen();
	 
	

	  @Query(value = "SELECT TOP(10)  p.product_name, o.product_id,p.anh_chinh,p.gia,p.giam_gia, COUNT(*) so_luong FROM order_details o\r\n"
	  		+ "	  		inner join products	p\r\n"
	  		+ "	  		ON o.product_id = p.product_id\r\n"
	  		+ "	  		group by p.product_name , o.product_id,p.anh_chinh,p.gia,p.giam_gia\r\n"
	  		+ "	  		order by so_luong DESC " , nativeQuery = true) 
	  List<Object[]>top10HotOrder();
	 
	
	@Query(value = "select top 5 * from products   order by created_at desc", nativeQuery = true)
	List<Product> top10new();
	
	@Query(value = "select top 5 * from products p where p.brand_id =?1  order by created_at desc", nativeQuery = true)
	List<Product> top10newforBrand(Integer cid);
	
	@Query(value = "SELECT TOP(3)  p.product_name, o.product_id,p.anh_chinh,p.gia,p.giam_gia, COUNT(*) so_luong FROM order_details o\r\n"
			+ "	  		 		inner join products	p\r\n"
			+ "	  		 		ON o.product_id = p.product_id\r\n"
			+ "					where p.brand_id = ?1\r\n"
			+ "	  	 		group by p.product_name , o.product_id,p.anh_chinh,p.gia,p.giam_gia\r\n"
			+ "	  	  		order by so_luong DESC ", nativeQuery = true)
	List<Object[]>top3ProducthotoderofBrand(Integer cid);
	
	
	List<Product> findByProductNameContaining(String name);

}
