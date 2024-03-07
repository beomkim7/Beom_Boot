package com.Beom.app.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Beom.app.board.BoardVO;
import com.Beom.app.util.Pager;

import lombok.extern.slf4j.Slf4j;
@SpringBootTest
@Slf4j
class QnaDAOTest {
	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	void getListTest()throws Exception{
		Pager pager = new Pager();
		pager.setPage(1L);
		pager.makeIndex();
		
		Long totalCount = qnaDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		
		log.info("pager {}",pager);
		
		List<BoardVO> ar = qnaDAO.getList(pager);
		assertEquals(10, ar.size());
	}
	
	//@Test
	void Test()throws Exception {
		for(int i = 0 ; i < 100 ; i++) {
		QnaVO qnaVO = new QnaVO();
		qnaVO.setBoardWriter("writer");
		qnaVO.setBoardTitle("title");
		qnaVO.setBoardContents("contents"+i);
		int result = qnaDAO.add(qnaVO);
		assertEquals(1, result);
		}
		
	}

}
