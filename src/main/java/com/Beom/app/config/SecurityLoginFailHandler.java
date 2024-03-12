package com.Beom.app.config;


import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.Beom.app.member.MemberVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SecurityLoginFailHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		//log.info("로그인 실패 원인 ==>{}",exception);
		String message = "";
		
		if(exception instanceof BadCredentialsException) {
			message="비번이 틀림";
		}
		
		if(exception instanceof InternalAuthenticationServiceException) {
			message="아이디가 없음";
		}
		if(exception instanceof AccountExpiredException) {
			message="계정유효기간 만료";
		}
		if(exception instanceof LockedException) {
			message="계정이 잠겨있다";
		}
		if(exception instanceof CredentialsExpiredException) {
			message="비밀번호 유효기간 만료";
		}
		if(exception instanceof DisabledException) {
			message="휴면 계정";
		}
		
		message = URLEncoder.encode(message,"UTF-8"); //forward사용시 주석 		
		response.sendRedirect("/member/login?message="+message); //redirect 방식
		
		//forward 방식
//		request.setAttribute("message", message);
//		request.setAttribute("memberVO", new MemberVO());
//		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);

	}
	
}
