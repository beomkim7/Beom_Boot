package com.Beom.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Beom.app.board.BoardVO;
import com.Beom.app.util.Pager;

import jakarta.annotation.PostConstruct;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("list")
	public String getList(Pager pager,Model model)throws Exception{
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
	public String add(NoticeVO noticeVO)throws Exception{
		int result = noticeService.add(noticeVO);
		
		return "board/add";
	}
}
