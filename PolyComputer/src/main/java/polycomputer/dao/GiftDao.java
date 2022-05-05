package polycomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.CPUSerie;
import polycomputer.entity.Gift;

@Repository
public interface GiftDao extends JpaRepository< Gift, Integer>{
	List<Gift> findByGiftNameContaining(String name);

}
