package com.Beom.app.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
@SpringBootTest
class MemberPasswordUpdate {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	void test()throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername("gkdlqjatj");
		memberVO.setPassword(passwordEncoder.encode("123456"));
		System.out.println(memberVO.getPassword());
		int result = memberDAO.update(memberVO);
		assertNotEquals(0, result);
	}

}
