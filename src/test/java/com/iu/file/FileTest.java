package com.iu.file;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.NoticeTestDTO;
import com.iu.notice.NoticeDTO;
import com.iu.s4.AbstractTest;

public class FileTest extends AbstractTest {

	@Inject
	FileDAO fileDAO;
	
	@Test
	public void test() {
		NoticeDTO noticeDTO = null;
		try {
			noticeDTO = fileDAO.test3();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(noticeDTO.getNum());
		System.out.println(noticeDTO.getWriter());
		System.out.println(noticeDTO.getContents());
		for(FileDTO fileDTO: noticeDTO.getFileNames()){
			System.out.println("----------------------");
			System.out.println(fileDTO.getFnum());
			System.out.println(fileDTO.getNum());
			System.out.println(fileDTO.getFilename());
			System.out.println(fileDTO.getOriname());
		}
	}

}
