package com.iu.s4;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;

@RestController	//json 전용 controller (모든 메서드에 @ResponseBody를 걸어줌)
@RequestMapping(value="/ajax/*")
public class AjaxController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="checkId", method=RequestMethod.GET)
	@ResponseBody
	public MemberDTO checkId(String id, Model model){

		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id");
		memberDTO.setPw("pw");
		memberDTO.setName("name");
		memberDTO.setPhone("010-5555-5555");
		//{"id":"id", "pw":"pw", "name":"name", "phone":"010-5555-5555"}와 같은 json 형식으로 만들기

		return memberDTO;
	}
	
	@RequestMapping(value="memberList")
	@ResponseBody
	public List<MemberDTO> selectList() throws Exception {

		List<MemberDTO> ar = memberService.selectList();

		return ar;
	}
}
