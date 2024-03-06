package com.Beom.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Beom.app.board.BoardService;
import com.Beom.app.board.BoardVO;
import com.Beom.app.util.Pager;


@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeIndex();
		pager.makeNum(noticeDAO.getTotalCount(pager));
		
		return noticeDAO.getList(pager);
	}
	
	@Override
	public int add(BoardVO boardVO) throws Exception {
		int result = noticeDAO.add(boardVO);
		return result;
	}
}
