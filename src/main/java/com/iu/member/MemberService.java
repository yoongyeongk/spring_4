package com.iu.member;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Inject
	private MemberDAO memberDAO;
	
	public List<MemberDTO> selectList() throws Exception{
		return memberDAO.selectList();
	}
}
