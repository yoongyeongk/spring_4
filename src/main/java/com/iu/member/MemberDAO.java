package com.iu.member;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE = "memberMapper.";
	
	public List<MemberDTO> selectList(){
		return sqlSession.selectList(NAMESPACE+"selectList");
	}
}
