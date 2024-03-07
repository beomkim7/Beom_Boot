package com.Beom.app.board.notice;

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
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Value("${app.upload.board.notice}")
	private String uploadPath;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeIndex();
		pager.makeNum(noticeDAO.getTotalCount(pager));
		
		return noticeDAO.getList(pager);
	}
	
	@Override
	public int add(BoardVO boardVO,MultipartFile [] attach) throws Exception {
		int result = noticeDAO.add(boardVO);
		
		for(MultipartFile multipartFile:attach) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(uploadPath, multipartFile);
			FileVO fileVO = new FileVO();
			fileVO.setBoardNum(boardVO.getBoardNum());
			fileVO.setFileName(fileName);
			fileVO.setOriName(multipartFile.getOriginalFilename());
			result = noticeDAO.addFile(fileVO);
		}
		return result;
	}
	
	@Override
	public BoardVO getDetail(BoardVO boardVO) throws Exception {
		
		return noticeDAO.getDetail(boardVO);
	}
	
	@Override
	public FileVO getFileDetail(FileVO fileVO) throws Exception {
		
		return noticeDAO.getFileDetail(fileVO);
	}
}
