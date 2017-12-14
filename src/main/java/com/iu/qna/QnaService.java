package com.iu.qna;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.notice.NoticeDTO;
import com.iu.util.FileSaver;
import com.iu.util.ListData;
import com.iu.util.Pager;
import com.iu.util.RowNum;

@Service
public class QnaService implements BoardService{

	@Inject
	private QnaDAO qnaDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private FileDAO fileDAO;
	
	@Override
	public ModelAndView selectList(ListData listData) throws Exception {
		ModelAndView mv = new ModelAndView();
		RowNum rowNum = listData.makeRow();
		Pager pager = listData.makePage(qnaDAO.totalCount(rowNum));
		List<BoardDTO> ar = qnaDAO.selectList(rowNum);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
		return mv;
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		qnaDAO.hitUpdate(num);
		BoardDTO boardDTO = qnaDAO.selectOne(num);
		return boardDTO;
	}

	@Override
	public int insert(BoardDTO boardDTO, HttpSession session) throws Exception {
		int result = qnaDAO.insert(boardDTO);
		if(((QnaDTO)boardDTO).getFiles().length != 0){
			for(MultipartFile multipartFile: ((QnaDTO)boardDTO).getFiles()){
				FileDTO fileDTO = new FileDTO();
				String filename = fileSaver.fileSave(multipartFile, session, "upload");
				fileDTO.setFilename(filename);
				fileDTO.setOriname(multipartFile.getOriginalFilename());
				fileDTO.setNum(boardDTO.getNum());
				fileDAO.insert(fileDTO);
			}
		}
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		int result = qnaDAO.update(boardDTO);
		return result;
	}

	@Override
	public int delete(int num) throws Exception {
		int result = qnaDAO.delete(num);
		return result;
	}
	
	public int reply(QnaDTO qnaDTO, HttpSession session) throws Exception {
		int result = qnaDAO.reply(qnaDTO);
		qnaDAO.stepUpdate(qnaDTO);
		if(qnaDTO.getFiles().length != 0){
			for(MultipartFile multipartFile: qnaDTO.getFiles()){
				FileDTO fileDTO = new FileDTO();
				String filename = fileSaver.fileSave(multipartFile, session, "upload");
				fileDTO.setFilename(filename);
				fileDTO.setOriname(multipartFile.getOriginalFilename());
				fileDTO.setNum(qnaDTO.getNum());
				fileDAO.insert(fileDTO);
			}
		}
		return result;
	}

	
}
