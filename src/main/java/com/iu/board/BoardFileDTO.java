package com.iu.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iu.file.FileDTO;

public class BoardFileDTO extends BoardDTO {
	
	private MultipartFile [] files;
	private List<FileDTO> fileNames;

	public List<FileDTO> getFileNames() {
		return fileNames;
	}

	public void setFileNames(List<FileDTO> fileNames) {
		this.fileNames = fileNames;
	}

	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}
}
