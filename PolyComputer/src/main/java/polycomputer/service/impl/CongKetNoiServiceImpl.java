package polycomputer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.BanPhimDao;
import polycomputer.dao.CongKetNoiDao;
import polycomputer.dao.AccountDao;
import polycomputer.entity.BanPhim;
import polycomputer.entity.CongKetNoi;
import polycomputer.entity.Account;
import polycomputer.service.BanPhimService;
import polycomputer.service.CongKetNoiService;
import polycomputer.service.AccountService;


@Service
public class CongKetNoiServiceImpl implements CongKetNoiService {
@Autowired
CongKetNoiDao dao;
@Override
public List<CongKetNoi> findAll() {
	
	return dao.findAll();
}
@Override
public CongKetNoi findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public CongKetNoi create(CongKetNoi congKetNoi) {
	return dao.save(congKetNoi);
}
@Override
public CongKetNoi update(CongKetNoi congKetNoi) {
	return dao.save(congKetNoi);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
