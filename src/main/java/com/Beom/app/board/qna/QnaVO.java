package com.Beom.app.board.qna;

import java.sql.Date;
import java.util.List;

import com.Beom.app.board.BoardVO;
import com.Beom.app.board.FileVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor //모든매게변수가진 생성자 boardVO(Long, String, String, String, Date, Long)
@NoArgsConstructor	//매개변수가 없는 기본생성자만들어줌
public class QnaVO extends BoardVO{
	private Long boardRef;
	private Long boardStep;
	private Long boardDepth;
}
