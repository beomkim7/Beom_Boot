package com.Beom.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;


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
							.requestMatchers("/notice/add","notice/delete").hasRole("ADMIN")
							.requestMatchers("notice/update").hasAnyRole("ADMIN","MANAGER")
							.anyRequest().permitAll()
				)//authorizeHttpRequests 끝부분
				.formLogin(
						(login)->
							login
								.loginPage("/member/login")
								.defaultSuccessUrl("/")
								.permitAll()
				)//formLogin 끝부분
				;
		return security.build();
	}
	
}
