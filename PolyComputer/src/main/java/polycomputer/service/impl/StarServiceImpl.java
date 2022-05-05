package polycomputer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.StarDao;
import polycomputer.dao.StatusDao;
import polycomputer.entity.Star;
import polycomputer.entity.Status;
import polycomputer.service.StarService;
import polycomputer.service.StatusService;

@Service
public class StarServiceImpl implements StarService {
@Autowired
StarDao dao;

@Override
public List<Star> findAll() {
	
	return dao.findAll();
}

}