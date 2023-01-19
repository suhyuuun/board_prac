package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.BoardDTO;
import dto.PageDTO;

public class BoardDaoImp implements BoardDao{
	private SqlSessionTemplate sqlSession;
	
	public BoardDaoImp() {

	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int count() {
		return sqlSession.selectOne("board.count");
	}

	@Override
	public List<BoardDTO> list(PageDTO pv) {
		return sqlSession.selectList("board.list",pv);
	}

	@Override
	public void readCount(int no) {
		sqlSession.selectList("board.readCount", no);
	}

	@Override
	public BoardDTO content(int no) {
		return sqlSession.selectOne("board.view", no);
	}

	@Override
	public void reStepCount(BoardDTO dto) {
		sqlSession.update("board.reStepCount",dto);
	}

	@Override
	public void save(BoardDTO dto) {
		sqlSession.insert("board.save",dto);
	}

	@Override
	public BoardDTO updateNo(int no) {
		return null;
	}

	@Override
	public void update(BoardDTO dto) {
		sqlSession.delete("board.update", dto);
	}

	@Override
	public void delete(int no) {
		sqlSession.delete("board.delete", no);
	}
	
}
