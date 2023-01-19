package service;

import java.util.List;

import dao.BoardDao;
import dto.BoardDTO;
import dto.PageDTO;

public class BoardServiceImp implements BoardService{
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
