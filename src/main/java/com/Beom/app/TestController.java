package com.Beom.app;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Beom.app.lambda.TestInterface;
import com.Beom.app.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TestController {


	@GetMapping("/")
	public String test() {

		//람다는 JS 와 비슷 function(){} = ()->{}
		//java ()->{}
		
		TestInterface ti = (int a,int b)->a+b;
		
		Supplier<MemberVO> s = ()-> new MemberVO();
		
		MemberVO memberVO = s.get();
		
		
		System.out.println(ti.t1(3, 2));
		
		System.out.println(ti.t1(6, 10));
		
//		TestInterface t2 = new TestInterface() {
//			
//			@Override
//			public int t1(int n1, int n2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		};
		
		return "index";
	}
	
	@GetMapping("/expired")
	public String expired(Model model) {
		model.addAttribute("result", "로그아웃");
		model.addAttribute("path", "/");
		System.out.println("들어왓니 ?");
		return "commons/result";
	}
}
