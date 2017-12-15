package com.iu.s4;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.notice.NoticeDTO;
import com.iu.notice.NoticeService;
import com.iu.util.ListData;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {

	@Inject
	private NoticeService noticeService;
	
	//selectList
	@RequestMapping(value="noticeList")
	public ModelAndView selectList(ModelAndView mv, ListData listData) throws Exception{
			mv = noticeService.selectList(listData);
			
			if(mv != null){
				throw new NullPointerException();	//exception을 강제로 발생시키는 것
			}
			
		return mv;
	}
			
	//selectOne
	@RequestMapping(value="noticeView")
	public ModelAndView selectOne(ModelAndView mv, int num, RedirectAttributes rd) throws Exception{
		BoardDTO boardDTO = noticeService.selectOne(num);
		
		if(boardDTO != null){
			mv.addObject("view", boardDTO);
			mv.setViewName("board/boardView");
		}else{
			rd.addFlashAttribute("message","해당 번호의 게시물이 존재하지 않습니다.");
			mv.setViewName("redirect:./noticeList");
		}
		mv.addObject("board", "notice");
		
		return mv;
	}
	
	//insert --> form 이동
	@RequestMapping(value="noticeWrite",method=RequestMethod.GET)
	public String insert(Model model) throws Exception {
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}
	
	//insert --> DB 처리
	@RequestMapping(value="noticeWrite",method=RequestMethod.POST)
	public String insert(RedirectAttributes rd, NoticeDTO noticeDTO, HttpSession session) throws Exception {
		int result = noticeService.insert(noticeDTO, session);
		
		String message = "등록 실패";
		if(result>0){
			message = "등록 성공";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:./noticeList";
	}
	
	//update --> form 이동
	@RequestMapping(value="noticeUpdate",method=RequestMethod.GET)
	public String update(Model model, int num) throws Exception {
		BoardDTO boardDTO = noticeService.selectOne(num);

		model.addAttribute("view", boardDTO);
		model.addAttribute("board", "notice");
		return "board/boardUpdate";
	}
	
	//update --> DB 처리
	@RequestMapping(value="noticeUpdate",method=RequestMethod.POST)
	public String update(BoardDTO boardDTO, RedirectAttributes rd) throws Exception {
		int result = noticeService.update(boardDTO);
	
		String message = "업데이트 실패";
		if(result>0){
			message = "업데이트 성공";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:./noticeList";
	}
	
	//delete
	@RequestMapping(value="noticeDelete")
	public String delete(int num, RedirectAttributes rd) throws Exception {
		int result = noticeService.delete(num);

		String message = "삭제 실패";
		if(result>0){
			message = "삭제 성공";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:./noticeList";
	}
	
}
