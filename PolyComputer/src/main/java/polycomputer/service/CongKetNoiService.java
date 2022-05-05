package polycomputer.service;

import java.util.List;

import polycomputer.entity.CongKetNoi;

public interface CongKetNoiService {

	void deleteById(Integer id);

	CongKetNoi update(CongKetNoi congKetNoi);

	CongKetNoi create(CongKetNoi congKetNoi);

	CongKetNoi findById(Integer id);

	List<CongKetNoi> findAll();

}
