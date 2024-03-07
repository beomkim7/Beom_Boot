package com.Beom.app.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FileVO {
	
	private Long fileNum;
	private Long boardNum;
	private String fileName;
	private String oriName;
}
