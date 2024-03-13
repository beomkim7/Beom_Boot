package com.Beom.app.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SecurityLoginSuccessHandler implements AuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
//		log.info("로그인 성공 했을 때 실행");
//		authentication.getPrincipal();//MemverVO
//		
//		response.sendRedirect("/");
		
		String rememberId =request.getParameter("rememberId");
		
		if(rememberId !=null) {
			//꺼낸 ID를 client에 cookie에 저장
			Cookie cookie =new Cookie("rememberId", authentication.getName());
			cookie.setMaxAge(600);
			cookie.setPath("/");//서브도메인에서도 사용가능
			
			response.addCookie(cookie);			
		}else {
			Cookie [] cookies =request.getCookies();
			
			for(Cookie c : cookies) {
				if(c.getName().equals("remamberId")) {
					c.setMaxAge(0);
					c.setValue("");
					c.setPath("/");
					response.addCookie(c);
					log.info("Cookie 삭제하기");
					break;
				}
			}
		}
		response.sendRedirect("/");
	}
}
