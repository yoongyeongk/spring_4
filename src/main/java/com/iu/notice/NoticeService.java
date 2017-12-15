package com.iu.notice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.ListData;
import com.iu.util.Pager;
import com.iu.util.RowNum;

@Service
public class NoticeService implements BoardService{

	@Inject
	private NoticeDAO noticeDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private FileDAO fileDAO;
	
	@Override
	public ModelAndView selectList(ListData listData) throws Exception {
		ModelAndView mv = new ModelAndView();
		RowNum rowNum = listData.makeRow();
		Pager pager = listData.makePage(noticeDAO.totalCount(rowNum));
		System.out.println(rowNum.getKind());
		System.out.println(rowNum.getSearch());
		List<BoardDTO> ar = noticeDAO.selectList(rowNum);
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");
		return mv;
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		noticeDAO.hitUpdate(num);
		BoardDTO boardDTO = noticeDAO.selectOne(num);
		/*List<FileDTO> fileNames = fileDAO.selectList(num);
		if(fileNames.size() != 0){
			((NoticeDTO)boardDTO).setFileNames(fileNames);
		}*/
		
		return boardDTO;
	}

	@Transactional
	@Override
	public int insert(BoardDTO boardDTO, HttpSession session) throws Exception {
		MultipartFile [] files = ((NoticeDTO)boardDTO).getFiles();
		int result = noticeDAO.insert(boardDTO);
		Map<String, Object> map = new HashMap<String, Object>();

		if(((NoticeDTO)boardDTO).getFiles() == null){
			FileDTO fileDTO = null;
			for(MultipartFile multipartFile: files){
				String fileName = fileSaver.fileSave(multipartFile, session, "upload");
				fileDTO = new FileDTO();
				fileDTO.setFilename(fileName);
				fileDTO.setOriname(multipartFile.getOriginalFilename());
				fileDTO.setNum(boardDTO.getNum());	
				//mapper에서 이미 num값을 boardDTO에 저장하므로 boardDTO insert 후에 진행하면 num값이 등록되어 있음
				fileDAO.insert(fileDTO);
			}
		}
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		int result = noticeDAO.update(boardDTO);
		return result;
	}

	@Override
	public int delete(int num) throws Exception {
		int result = noticeDAO.delete(num);
		return result;
	}
	
	
}
