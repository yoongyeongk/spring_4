package com.iu.qna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s4.AbstractTest;
import com.iu.util.RowNum;

public class QnaDAOTest extends AbstractTest {

	@Inject
	QnaDAO qnaDAO;
	
	public void reply() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("test2");
		qnaDTO.setWriter("test");
		qnaDTO.setContents("testContents");
		qnaDTO.setRef(460);
		qnaDTO.setStep(0);
		qnaDTO.setDepth(0);
		qnaDAO.stepUpdate(qnaDTO);
		int result = qnaDAO.reply(qnaDTO);
		assertEquals(result, 1);
	}
	
	public void getNum() throws Exception{
		int result = qnaDAO.getNum();
		System.out.println(result);
	}
	
	public void hitUpdate() throws Exception{
		int result = qnaDAO.hitUpdate(229);
		assertEquals(result, 1);
	}
	
	public void totalCount() throws Exception{
		RowNum rowNum = new RowNum();
		rowNum.setKind("writer");
		rowNum.setSearch("iu");
		int result = qnaDAO.totalCount(rowNum);
		System.out.println(result);
	}
	
	public void delete() throws Exception{
		int result = qnaDAO.delete(487);
		assertEquals(result, 1);
	}
	
	public void update() throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("test111");
		boardDTO.setWriter("test");
		boardDTO.setContents("testContents111");
		boardDTO.setNum(487);
		int result = qnaDAO.update(boardDTO);
		assertEquals(result, 1);
	}
	
	public void insert() throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("test");
		boardDTO.setWriter("test");
		boardDTO.setContents("testContents");
		int result = qnaDAO.insert(boardDTO);
		assertEquals(result, 1);
	}
	
	public void selectList() throws Exception{
		RowNum rowNum = new RowNum();
		rowNum.setStartRow(1);
		rowNum.setLastRow(10);
		rowNum.setKind("writer");
		rowNum.setSearch("iu");
		List<BoardDTO> ar = qnaDAO.selectList(rowNum);
		for(BoardDTO boardDTO: ar){
			System.out.print(boardDTO.getNum()+"    ");
			System.out.println(boardDTO.getWriter());
		}
		assertTrue(ar.size()>0);
	}
	
	public void selectOne() throws Exception{
		BoardDTO boardDTO = qnaDAO.selectOne(204);
		assertNotNull(boardDTO);
	}
	
	@Test
	public void test() {
		try {
			this.reply();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
