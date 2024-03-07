package com.Beom.app.board.qna;

import org.apache.ibatis.annotations.Mapper;
import com.Beom.app.board.BoardDAO;
import com.Beom.app.board.BoardVO;

@Mapper
public interface QnaDAO extends BoardDAO {

	public int refUpdate(BoardVO boardVO)throws Exception;
	
}
