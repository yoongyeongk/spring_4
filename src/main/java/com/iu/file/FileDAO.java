package com.iu.file;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.NoticeTestDTO;
import com.iu.notice.NoticeDTO;

@Repository
public class FileDAO {

	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE = "fileMapper.";
	
	public NoticeDTO test3() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"selectTest3");
	}
	
	public NoticeTestDTO test2() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"selectTest2", 1);
	}
	
	public FileDTO test() {
		return sqlSession.selectOne(NAMESPACE+"selectTest", 1);
	}
	
	public int insert(FileDTO fileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"insert", fileDTO);
	}
	
	public List<FileDTO> selectList(int num) throws Exception{
		return sqlSession.selectList(NAMESPACE+"selectList", num);
	}
}
