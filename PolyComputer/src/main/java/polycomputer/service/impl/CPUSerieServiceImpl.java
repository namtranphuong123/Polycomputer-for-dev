package polycomputer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.BanPhimDao;
import polycomputer.dao.CPUDao;
import polycomputer.dao.CPUSerieDao;
import polycomputer.dao.CongKetNoiDao;
import polycomputer.entity.BanPhim;
import polycomputer.entity.CPU;
import polycomputer.entity.CPUSerie;
import polycomputer.entity.CongKetNoi;
import polycomputer.service.BanPhimService;
import polycomputer.service.CPUSerieService;
import polycomputer.service.CongKetNoiService;
import polycomputer.service.AccountService;


@Service
public class CPUSerieServiceImpl implements CPUSerieService {
@Autowired
CPUSerieDao dao;
@Override
public List<CPUSerie> findAll() {
	
	return dao.findAll();
}
@Override
public CPUSerie findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public CPUSerie create(CPUSerie CPUSerie) {
	return dao.save(CPUSerie);
}
@Override
public CPUSerie update(CPUSerie CPUSerie) {
	return dao.save(CPUSerie);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}

@Override
public List<CPUSerie> findByCpuSerieNameContaining(String name) {
	return dao.findByCpuSerieNameContaining(name);
}

}