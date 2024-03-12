package com.Beom.app.member;

import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Beom.app.member.goups.MemberJoinGroup;
import com.Beom.app.member.goups.MemberUpdateGroup;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("page")
	public void page(HttpSession session)throws Exception{
		Enumeration<String> en = session.getAttributeNames();//속성명 가져오기
		while(en.hasMoreElements()) {
			log.info("=======attribut{}============",en.nextElement());//속성명 조회하기
		}
		Object obj= session.getAttribute("SPRING_SECURITY_CONTEXT");//속성명 조회해서 값넣기
		log.info("===ogj{}",obj);
		
		SecurityContextImpl contextImpl = (SecurityContextImpl)obj;
		String name = contextImpl.getAuthentication().getName();
		MemberVO memberVO =(MemberVO)contextImpl.getAuthentication().getPrincipal();
		log.info("====name{}",name);
		log.info("====memberVO{}",memberVO);
		
		//세션 받거나 SecurityContextHolder 이용
		SecurityContext context = SecurityContextHolder.getContext();
		name = context.getAuthentication().getName();
		
	}
	
	@GetMapping("login")
	public String login(@ModelAttribute MemberVO memberVO)throws Exception{		
		return "member/login";
	}	
	
	
	@GetMapping("update")
	public void update(Model model)throws Exception{
		
	}
	
	@PostMapping("update")//검증													검증결과
	public String update(@Validated(MemberUpdateGroup.class) MemberVO memberVO,BindingResult bindingResult)throws Exception{
		if(bindingResult.hasErrors()) {
			return "member/update";
		}
		return "redirct:../";
	}
	
	@GetMapping("add")
	public void add(@ModelAttribute MemberVO memberVO)throws Exception{
		
		//model.addAttribute("memberVO", memberVO);
	}
	
	@PostMapping("add")
	public String add(@Validated(MemberJoinGroup.class) MemberVO memberVO, BindingResult bindingResult,Model model)throws Exception{
		
		boolean check = memberService.checkMember(memberVO, bindingResult);
		if(check) {
			return "member/add";
		}
//		if(bindingResult.hasErrors()) {
//			return "member/add";
//		}
		
		int result = memberService.add(memberVO);
		
		model.addAttribute("result", "member.add.result");
		model.addAttribute("path", "/");
		
		//service로 보냄
		return "commons/result";
	}
	

}