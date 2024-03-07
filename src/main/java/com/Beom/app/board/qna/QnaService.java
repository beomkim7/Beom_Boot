package com.Beom.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Beom.app.board.BoardService;
import com.Beom.app.board.BoardVO;
import com.Beom.app.board.FileVO;
import com.Beom.app.util.FileManager;
import com.Beom.app.util.Pager;
@Service
public class QnaService implements BoardService{
	@Autowired
	private QnaDAO qnaDAO;
	@Value("${app.upload.board.qna}")
	private String uploadPath;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {	
				
		pager.makeIndex();
		pager.makeNum(qnaDAO.getTotalCount(pager));
			
		return qnaDAO.getList(pager);
	}
	
	@Override
	public int add(BoardVO boardVO, MultipartFile[] attachs) throws Exception {
		
		return 0;
	}
	@Override
	public BoardVO getDetail(BoardVO boardVO) throws Exception {

		return null;
	}
	
	@Override
	public FileVO getFileDetail(FileVO fileVO) throws Exception {
		
		return null;
	}
	
}
