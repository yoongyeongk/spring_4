package com.iu.s4;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.file.FileDTO;
import com.iu.file.PhotoDTO;
import com.iu.file.PhotoService;

@Controller
@RequestMapping(value="/file/*")
public class FileController {

	@Inject
	private PhotoService photoService;
	
	@RequestMapping(value="fileDown")
	public ModelAndView fileDown(FileDTO fileDTO, HttpSession session){
		String filePath = session.getServletContext().getRealPath("resources/upload");
		//저장될 실제 파일 이름
		File file = new File(filePath, fileDTO.getFilename());
		ModelAndView mv = new ModelAndView();
		mv.addObject("down", file);
		mv.addObject("oriname", fileDTO.getOriname());
		//viewName은 class명과 일치해야 class를 실행할 수 있음, 
		//만약 이름이 다르다면 context.xml에 어떤 아이디일 때 어떤 객체를 생성할 지 객체를 등록해야 함 
		mv.setViewName("FileDown");
		
		return mv;
	}
	
	//SmartEditor Image Upload
	@RequestMapping("photoUpload")
	public String photoUpload(PhotoDTO photoDTO, HttpSession session){
		return photoService.photoUpload(photoDTO, session);
	}
}
