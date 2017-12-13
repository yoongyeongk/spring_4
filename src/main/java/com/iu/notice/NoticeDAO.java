package com.iu.notice;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.RowNum;

@Repository
public class NoticeDAO implements BoardDAO{

	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "noticeMapper.";	//어떤 mapper파일을 쓸지 명시해주는 것
	//private static final String namespace2 = "testMapper.";	매핑을 두개 받아야 할 때는 새롭게 변수로 선언하면 됨
	
	@Override
	public List<BoardDTO> selectList(RowNum rowNum) throws Exception {
		return sqlSession.selectList(namespace+"selectList", rowNum); 
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		System.out.println("Before:"+boardDTO.getNum());
		int result = sqlSession.insert(namespace+"insert", boardDTO);
		System.out.println("After:"+boardDTO.getNum());
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(namespace+"update", boardDTO);
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

	public NoticeDTO selectOne(int num) throws Exception{
		return sqlSession.selectOne(namespace+"selectOne", num);	//한 개의 파라미터만 보낼 수 있음
	}
	
	public int delete(int num) throws Exception{
		return sqlSession.delete(namespace+"delete", num);
	}
	
}
