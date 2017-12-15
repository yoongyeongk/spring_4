package com.iu.s4;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.qna.QnaDTO;
import com.iu.qna.QnaService;
import com.iu.util.ListData;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {

	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value="qnaList")
	public ModelAndView selectList(ListData listData, ModelAndView mv){
		try {
			mv = qnaService.selectList(listData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@RequestMapping(value="qnaView")
	public ModelAndView selectOne(ModelAndView mv, int num, RedirectAttributes rd){
		BoardDTO boardDTO = null;
		try {
			boardDTO = qnaService.selectOne(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(boardDTO != null){
			mv.addObject("view", boardDTO);
			mv.setViewName("board/boardView");
		}else{
			mv.setViewName("redirect:./qnaList");
			rd.addFlashAttribute("message", "해당 번호의 게시글이 존재하지 않습니다.");
		}
		mv.addObject("board", "qna");
		
		return mv;
	}
	
	@RequestMapping(value="qnaWrite", method=RequestMethod.GET)
	public String insert(Model model){
		model.addAttribute("board", "qna");
		return "board/boardWrite";
	}
	
	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public String insert(QnaDTO qnaDTO, RedirectAttributes rd, HttpSession session){
		int result = 0;
		try {
			result = qnaService.insert(qnaDTO, session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "등록 실패";
		if(result>0){
			message = "등록 성공";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:./qnaList";
	}
	
	@RequestMapping(value="qnaUpdate", method=RequestMethod.GET)
	public String update(Model model, int num){
		BoardDTO boardDTO = null;
		try {
			boardDTO = qnaService.selectOne(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("view", boardDTO);
		model.addAttribute("board", "qna");
		return "board/boardUpdate";
	}
	
	@RequestMapping(value="qnaUpdate", method=RequestMethod.POST)
	public String update(QnaDTO qnaDTO, RedirectAttributes rd){
		int result = 0;
		try {
			result = qnaService.update(qnaDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "수정 실패";
		if(result>0){
			message = "수정 성공";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:./qnaList";
	}
	
	@RequestMapping(value="qnaDelete")
	public String delete(int num, RedirectAttributes rd){
		int result = 0;
		try {
			result = qnaService.delete(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "삭제 실패";
		if(result>0){
			message = "삭제 성공";
		}
		rd.addAttribute("message", message);
		return "redirect:./qnaList";
	}
	
	@RequestMapping(value="qnaReply", method=RequestMethod.GET)
	public String reply(int num, Model model){
		QnaDTO qnaDTO = null;
		try {
			qnaDTO = (QnaDTO)qnaService.selectOne(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(qnaDTO != null){
			model.addAttribute("view", qnaDTO);
		}
		return "board/boardReply";
	}
	
	@RequestMapping(value="qnaReply", method=RequestMethod.POST)
	public String reply(QnaDTO qnaDTO, RedirectAttributes rd, HttpSession session){
		int result = 0;
		try {
			result = qnaService.reply(qnaDTO, session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "등록 실패";
		if(result>0){
			message = "등록 성공";
		}
		return "redirect:./qnaList";
	}
}
