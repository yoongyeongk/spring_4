package com.iu.s4;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.member.MemberService;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {

	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="memberJoin")
	public void memberJoin(){}
	
}
