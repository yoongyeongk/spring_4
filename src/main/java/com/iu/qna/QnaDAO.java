package com.iu.qna;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.RowNum;

@Repository
public class QnaDAO implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "qnaMapper.";
	
	public int stepUpdate(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(namespace+"stepUpdate", qnaDTO);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(namespace+"reply", qnaDTO);
	}
	
	@Override
	public List<BoardDTO> selectList(RowNum rowNum) throws Exception {
		return sqlSession.selectList(namespace+"selectList", rowNum);
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		return sqlSession.selectOne(namespace+"selectOne", num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(namespace+"insert", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(namespace+"update", boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		return sqlSession.delete(namespace+"delete", num);
	}

	@Override
	public int totalCount(RowNum rowNum) throws Exception {
		return sqlSession.selectOne(namespace+"totalCount", rowNum);
	}

	@Override
	public int hitUpdate(int num) throws Exception {
		return sqlSession.update(namespace+"hitUpdate", num);
	}

	@Override
	public int getNum() throws Exception {
		return sqlSession.selectOne(namespace+"getNum");
	}
}
