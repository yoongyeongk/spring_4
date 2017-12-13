package com.iu.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	public String fileSave(MultipartFile multipartFile, HttpSession session, String path) throws Exception{
		//1.realPath
		String filePath = session.getServletContext().getRealPath("resources/"+path);
		File file = new File(filePath);
		System.out.println(filePath);
		
		if(!file.exists()){
			file.mkdirs();
		}
		
		//2.fileName
		String fileName = multipartFile.getOriginalFilename();
		fileName = fileName.substring(fileName.lastIndexOf("."));
		fileName = UUID.randomUUID().toString()+fileName;
		
		//3.save
		file = new File(filePath, fileName);
		multipartFile.transferTo(file);
		
		return fileName;
	}
}
