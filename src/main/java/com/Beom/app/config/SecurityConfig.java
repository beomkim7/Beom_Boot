package com.Beom.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import com.Beom.app.member.MemberService;



@Configuration //xml 파일
//@EnableWebSecurity(debug = true)
@EnableWebSecurity //보안 나의 보안적용
public class SecurityConfig {
	
	@Autowired
	private SecurityLoginSuccessHandler handler;
	
	@Autowired
	private SecurityLoginFailHandler handler2;
	
	@Autowired
	private MemberService memberService;
	
	@Value("${security.debugMode}")
	private boolean debugMode;
	
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web
				.debug(debugMode)
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
							.requestMatchers("/member/page","/member/logout").authenticated()
							.requestMatchers("/notice/add","notice/delete").hasRole("ADMIN") //ADMIN만 가능
							.requestMatchers("notice/update").hasAnyRole("ADMIN","MANAGER") //ADMIN,"MANAGER만 가능
							.anyRequest().permitAll()
				)//authorizeHttpRequests 끝부분
				.formLogin(
						(login)->
							login
								.loginPage("/member/login")
								//.defaultSuccessUrl("/") successHandler와 같이 사용불가
								.successHandler(handler)
								//.failureUrl("/notice/list") 로그인 실패했을때 보내고싶은곳
								.failureHandler(handler2)
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
								//.logoutSuccessHandler(null)
								.invalidateHttpSession(true) //로그아웃시 session만료
								.permitAll()
				)//logout 끝부분
			      .rememberMe((rememberMe)->rememberMe
		                  .rememberMeParameter("rememberMe")   //파라미터명
		                  .tokenValiditySeconds(60)   //remember-me token의 유효 시간 (Cookie) , 초단위
		                  .key("rememberMe")//키 필수 암거나알아서
		                  .userDetailsService(memberService)//인증 절차를 진행할 UserDetailService, 필수
		                  .authenticationSuccessHandler(handler) //Login이 성공했을 때 실행할 Handler
		                  //.userSecureCookie(false)
		                  //로그아웃안하고 창나갔다가 다시 들어왔을때 로그인 되어있는지 확인   // JSESSIONID가 만료되도 remember-me를 체크하면 로그인 유지		
				)//rememberMe 끝부분
			      .sessionManagement(
			    		  (sessionManagement)->
			    		  			sessionManagement
						                  .maximumSessions(1)       //최대 허용 가능한 session 수, -1 이면 무제한
						                  .maxSessionsPreventsLogin(false) //false - 이전 사용자 세션만료 true - 현재 접속 하려는 사용자 인증 실패 
						                  .expiredUrl("/expired")         //세션이 만료되었을 경우 리다이렉트 할 페이지
						      //동시접속 해보기..안되네...
						                  
			    )//sessionManagement 끝부분
				.oauth2Login(
						(oauth2Login)->
							oauth2Login.userInfoEndpoint(
									(ue)->ue.userService(memberService)
									)
				)//oauth2Login 끝부분
					
						
				
				;
		return security.build();
	}
	
	
}
