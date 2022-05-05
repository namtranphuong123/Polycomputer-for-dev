package polycomputer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.Status;

@Repository
public interface StatusDao extends JpaRepository<Status, Integer>{

}
