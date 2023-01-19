package dao;

import java.util.List;

import dto.BoardDTO;
import dto.PageDTO;

public interface BoardDao {
	public int count();
	public List<BoardDTO> list(PageDTO pv);
	public void readCount(int no);
	public BoardDTO content(int no);
	public void reStepCount (BoardDTO dto);
	public void save(BoardDTO dto);
	public BoardDTO updateNo(int no);
	public void update(BoardDTO dto);
	public void delete(int no);
	
}
