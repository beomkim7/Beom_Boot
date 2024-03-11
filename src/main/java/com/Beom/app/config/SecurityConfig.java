package com.Beom.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;


@Configuration //xml 파일
@EnableWebSecurity //보안 나의 보안적용
public class SecurityConfig {
	
	
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web
				.ignoring()
				.requestMatchers("/css/**")
				.requestMatchers("/js/**")
				.requestMatchers("/vendor/**")
				.requestMatchers("/img/**")
				.requestMatchers("/favicon/**")
				;
	}
	@Bean
	SecurityFilterChain filterChain (HttpSecurity security) throws Exception {
		
		security
			//권한에 관련된 설정
			.authorizeHttpRequests(
				(authorizeRequests)->
					
						authorizeRequests
							.requestMatchers("/").permitAll()
							.requestMatchers("/member/add").permitAll()
							.requestMatchers("/notice/list").authenticated()  //로그인 사용자만 가능
							.requestMatchers("/notice/add","notice/delete").hasRole("ADMIN") //ADMIN만 가능
							.requestMatchers("notice/update").hasAnyRole("ADMIN","MANAGER") //ADMIN,"MANAGER만 가능
							.anyRequest().permitAll()
				)//authorizeHttpRequests 끝부분
				.formLogin(
						(login)->
							login
								.loginPage("/member/login")
								.defaultSuccessUrl("/")
								//파라미터이름이 username이 아닌 'id'를 사용했을경우
								//.usernameParameter("id")
								//파라미터이름이 password가 아닌 'pw'를 사용했을경우
								//.passwordParameter("pw")
								.permitAll()
				)//formLogin 끝부분
				.logout(
						(logout)->
							logout
								//.logoutUrl("/member/logout")
								.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
								.logoutSuccessUrl("/")
								.invalidateHttpSession(true) //로그아웃시 session만료
								.permitAll()
						)
				;
		return security.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		//password 암호화 해주는 객체
		return new BCryptPasswordEncoder();
	}
	
}
