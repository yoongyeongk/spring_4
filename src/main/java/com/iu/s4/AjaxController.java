package com.iu.s4;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.member.MemberService;

@Controller
@RequestMapping(value="/ajax/*")
public class AjaxController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="checkId", method=RequestMethod.POST)
	public String checkId(String id, Model model){
		String result = "ok";
		model.addAttribute("data", result);
		
		return "common/ajax";
	}
	
	@RequestMapping(value="memberList")
	public ModelAndView selectList() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", memberService.selectList());
		mv.setViewName("common/list");
		
		return mv;
	}
}
