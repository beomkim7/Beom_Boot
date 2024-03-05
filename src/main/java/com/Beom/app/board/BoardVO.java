package com.Beom.app.board;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor //모든매게변수가진 생성자 boardVO(Long, String, String, String, Date, Long)
@NoArgsConstructor	//매개변수가 없는 기본생성자만들어줌
//@Setter
//@Getter
public class BoardVO {
	private Long boardNum;
	private String boardWriter;
	private String boardTitle;
	private String boardContents;
	private Date boardDate;
	private Long boardHit;
	
	
}
