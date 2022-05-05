package polycomputer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import polycomputer.entity.Rating;

@Repository
public interface RatingDao extends JpaRepository<Rating, Integer>{

}
