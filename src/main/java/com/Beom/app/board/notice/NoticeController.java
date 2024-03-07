package com.Beom.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.Beom.app.board.BoardVO;
import com.Beom.app.board.FileVO;
import com.Beom.app.util.FileManager;
import com.Beom.app.util.Pager;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice/*")
@Slf4j
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	@Value("${board.notice.name}")
	private String uploadPath;
	
	@ModelAttribute("board")
	public String board() {
		return this.uploadPath;
	}
	
	@GetMapping("list")
	public String getList(Pager pager,Model model)throws Exception{
		log.info("==========={}==========",uploadPath);
		List<BoardVO> ar = noticeService.getList(pager);	
		model.addAttribute("list",ar);
		model.addAttribute("pager", pager);
		return "board/list";
	}
	
	@GetMapping("add")
	public String add()throws Exception{
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(NoticeVO noticeVO,MultipartFile [] attach)throws Exception{
		int result = noticeService.add(noticeVO,attach);				
		
		return "redirect:./list";
	}
	
	@GetMapping("detail")
	public String getDetail(BoardVO boardVO,Model model)throws Exception{
		boardVO = noticeService.getDetail(boardVO);		
		model.addAttribute("vo", boardVO);
		
		return "board/detail";
	}
	
	@GetMapping("fileDown")
	public String fileDown(FileVO fileVO, Model model)throws Exception{
		fileVO = noticeService.getFileDetail(fileVO);
		
		model.addAttribute("fileVO", fileVO);
		
		return "fileDownView";
	}
	
}
