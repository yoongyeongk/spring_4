package com.iu.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s4.AbstractTest;
import com.iu.util.RowNum;

public class NoticeDAOTest extends AbstractTest {

	@Inject
	NoticeDAO noticeDAO;
	
	public void hitUpdate() throws Exception{
		int result = noticeDAO.hitUpdate(485);
		assertEquals(result, 1);
	}
	
	public void getNum() throws Exception{
		int result = noticeDAO.getNum();
		System.out.println("getNum:"+result);
	}
	
	public void getTotalCount() throws Exception{
		RowNum rowNum = new RowNum();
		rowNum.setKind("title");
		rowNum.setSearch("iu");
		int result = noticeDAO.totalCount(rowNum);
		System.out.println(result);
	}
	
	public void selectOne() throws Exception{
		NoticeDTO noticeDTO = noticeDAO.selectOne(485);
		System.out.println(noticeDTO.getContents());
	}
	
	public void selectList() throws Exception{
		RowNum rowNum = new RowNum();
		rowNum.setStartRow(1);
		rowNum.setLastRow(10);
		rowNum.setKind("title");
		rowNum.setSearch("iu");
		List<BoardDTO> ar = noticeDAO.selectList(rowNum);
		//assertNotNull(ar);
		for(BoardDTO noticeDTO: ar){
			System.out.print(noticeDTO.getNum()+"    ");
			System.out.println(noticeDTO.getTitle());
		}
		assertTrue(ar.size()>0);
	}
	
	public void insert(){
		BoardDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("iu_test");
		noticeDTO.setWriter("iu");
		noticeDTO.setContents("iu_content");
		int result = 0;
		try {
			result = noticeDAO.insert(noticeDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(result, 1);
		/*int result = 0;
		try {
			result = noticeDAO.delete(484);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(result, 1);*/
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
