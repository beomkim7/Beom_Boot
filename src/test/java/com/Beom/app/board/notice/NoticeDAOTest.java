package com.Beom.app.board.notice;

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
class NoticeDAOTest {
	@Autowired
	private NoticeDAO noticeDAO;
	
	
	@Test
	void getListTest()throws Exception{
		Pager pager = new Pager();
		pager.setPage(1L);		
		pager.makeIndex();
		
		Long totalcount = noticeDAO.getTotalCount(pager);
		pager.makeNum(totalcount);
		
		log.info("pager {} ",pager);
		
		List<BoardVO> ar = noticeDAO.getList(pager);
		assertEquals(10, ar.size());
	}
	
	//@Test
	void test()throws Exception {
		for(int i=0 ; i<100;i++) {				
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setBoardWriter("tester");
		noticeVO.setBoardTitle("test Title");
		noticeVO.setBoardContents("test contents"+i);
		int result = noticeDAO.add(noticeVO);
		assertEquals(1, result);
		}
		System.out.println("finish");
	}

}
