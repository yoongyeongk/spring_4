package com.iu.notice;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.s4.AbstractTest;
import com.iu.util.ListData;

public class NoticeServiceTest extends AbstractTest {

	@Inject
	NoticeService noticeService;
	
	public void delete() throws Exception{
		int result = noticeService.delete(507);
		assertEquals(result, 1);
	}
	
	public void update() throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("titleTTT");
		boardDTO.setContents("contentsTTT");
		boardDTO.setNum(507);
		int result = noticeService.update(boardDTO);
		assertEquals(result, 1);
	}
	
	public void insert() throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("title");
		boardDTO.setWriter("test");
		boardDTO.setContents("contents");
		int result = noticeService.insert(boardDTO);
		assertEquals(result, 1);
	}
	
	public void selectOne() throws Exception{
		BoardDTO boardDTO = noticeService.selectOne(485);
		System.out.println(boardDTO.getTitle());
	}
	
	public void selectList() throws Exception{
		ListData listData = new ListData();
		ModelAndView mv = noticeService.selectList(listData);
		Map<String, Object> map = mv.getModel();
		List<BoardDTO> ar = (List<BoardDTO>)map.get("list");
		for(BoardDTO boardDTO: ar){
			System.out.print(boardDTO.getNum()+"  ");
			System.out.println(boardDTO.getTitle());
		}
		System.out.println((String)map.get("board"));
	}
	
	@Test
	public void test() {
		try {
			this.selectList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
