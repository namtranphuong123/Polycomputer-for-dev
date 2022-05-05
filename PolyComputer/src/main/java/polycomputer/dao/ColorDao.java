package polycomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.Color;

@Repository
public interface ColorDao extends JpaRepository<Color, Integer>{
	List<Color> findByColorNameContaining(String name);
}
