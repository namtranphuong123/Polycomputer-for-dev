package polycomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.BanPhim;

@Repository
public interface BanPhimDao extends JpaRepository<BanPhim, Integer>{
	List<BanPhim> findByBanPhimNameContaining(String name);
}
