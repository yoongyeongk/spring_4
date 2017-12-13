package com.iu.qna;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.notice.NoticeDTO;
import com.iu.s4.AbstractTest;
import com.iu.util.ListData;

public class QnaServiceTest extends AbstractTest {

	@Inject
	QnaService qnaService;
	
	public void delete() throws Exception{
		int result = qnaService.delete(524);
		assertEquals(result, 1);
	}
	
	public void update() throws Exception{
		BoardDTO boardDTO = new NoticeDTO();
		boardDTO.setTitle("titleTTT");
		boardDTO.setContents("contentsTTT");
		boardDTO.setNum(524);
		int result = qnaService.update(boardDTO);
		assertEquals(result, 1);
	}
	
	public void insert() throws Exception{
		BoardDTO boardDTO = new NoticeDTO();
		boardDTO.setTitle("title");
		boardDTO.setWriter("wirter");
		boardDTO.setContents("contents");
		int result = qnaService.insert(boardDTO);
		assertEquals(result, 1);
	}
	
	public void selectOne() throws Exception{
		BoardDTO boardDTO = qnaService.selectOne(348);
		System.out.println(boardDTO.getTitle());
	}
	
	public void selectList() throws Exception{
		ListData listData = new ListData();
		ModelAndView mv = qnaService.selectList(listData);
		Map<String, Object> map = mv.getModel();
		List<BoardDTO> ar = (List<BoardDTO>)map.get("list");
		for(BoardDTO boardDTO: ar){
			System.out.print(boardDTO.getNum()+"   ");
			System.out.println(boardDTO.getTitle());
		}
		System.out.println((String)map.get("board"));
	}
	
	@Test
	public void test() {
		try {
			this.insert();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
