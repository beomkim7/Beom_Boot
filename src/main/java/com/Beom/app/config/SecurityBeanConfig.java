package com.Beom.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityBeanConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		//password 암호화 해주는 객체
		return new BCryptPasswordEncoder();
	}

}