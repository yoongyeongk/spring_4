package com.iu.board;

import com.iu.file.FileDTO;

public class NoticeTestDTO extends BoardDTO{

	private FileDTO fileDTO;

	public FileDTO getFileDTO() {
		return fileDTO;
	}

	public void setFileDTO(FileDTO fileDTO) {
		this.fileDTO = fileDTO;
	}
	
}
