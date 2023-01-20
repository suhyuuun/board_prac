package service;

import java.util.List;

import dao.BoardDao;
import dto.BoardDTO;
import dto.PageDTO;

public class BoardServiceImp implements BoardService {
	private BoardDao dao;

	public BoardServiceImp() {

	}

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@Override
	public int countProcess() {
		return dao.count();
	}

	@Override
	public List<BoardDTO> listProcess(PageDTO pv) {
		return dao.list(pv);
	}

	@Override
	public void insertProcess(BoardDTO dto) {
		if(dto.getRef()!=0) {
			dao.reStepCount(dto);
			dto.setRe_step(dto.getRe_step() + 1);
			dto.setRe_level(dto.getRe_level() + 1);
		}
		dao.save(dto);
	}

	@Override
	public BoardDTO contentProcess(int no) {
		dao.readCount(no);
		return dao.content(no);
	}

	@Override
	public void reStepProcess(BoardDTO dto) {

	}

	@Override
	public void updateProces(BoardDTO dto) {
		dao.update(dto);
	}

	@Override
	public void deleteProcess(int no) {
		dao.delete(no);
	}

}
