package service;

import java.util.List;

import dto.BoardDTO;
import dto.PageDTO;

public interface BoardService {
	public int countProcess();
	public List<BoardDTO> listProcess(PageDTO pv);
	public BoardDTO contentProcess(int no);
	public void reStepProcess(BoardDTO dto);
	public void updateProces(BoardDTO dto);
	public void deleteProcess(int no);
}
