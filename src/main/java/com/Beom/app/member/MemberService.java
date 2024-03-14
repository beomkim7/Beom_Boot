package com.Beom.app.member;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MemberService extends DefaultOAuth2UserService implements UserDetailsService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	//@Qualifier("ps")
	private PasswordEncoder passwordEncoder;
	
	
	//DefaultOAuth2UserService에서 오버라이딩
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		log.info("kakao =====>{}",userRequest);
		
		ClientRegistration c = userRequest.getClientRegistration();
		
		log.info("ClientId======>{}",c.getClientId());
		log.info("ClientName======>{}",c.getClientName());
		
		OAuth2User user = super.loadUser(userRequest);
		
		log.info("{}",user);
		log.info("{}",user.getName());
		log.info("{}",user.getAuthorities());
		
		log.info("property : {}",user.getAttribute("properties").toString());
		if(c.getClientName().equals("Kakao")) {
			user = this.kakao(user);
		}
		((MemberVO)user).setSocial(c.getClientName());
		return user;
	}
	
	private OAuth2User kakao(OAuth2User oAuth2User) {
		Map<String, Object> map = oAuth2User.getAttribute("properties");		
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername(oAuth2User.getName());
		memberVO.setName(map.get("nickname").toString());
		memberVO.setAttributes(oAuth2User.getAttributes());
		
		
		List<RoleVO> list = new ArrayList<>();
		
		RoleVO roleVO = new RoleVO();
		roleVO.setRoleName("ROLE_MEMBER"); //지금은 걍집어넣음 나중에 디비에 멤버를 넣기
		
		list.add(roleVO);
		
		memberVO.setRoleVOs(list);
		
		return memberVO;
	}
	
	//UserDetailsService에서 오버라이딩
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername(username);
		
		log.info("-----로그인 진행-----");
		log.info("-----{}-----",username);
		
		try {
			memberVO= memberDAO.getDetail(memberVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memberVO;
	}
	
	//삭제할 메서드. . .
	public MemberVO detail() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername("mym9211");
		return memberDAO.getDetail(memberVO);
	}
	
	public int add(MemberVO memberVO)throws Exception{
		//평문 password를 암호화
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
		int result = memberDAO.add(memberVO);
		//회원의 Role 정보 저장
		result = memberDAO.memberRole(memberVO);
		return result; 
	}
	
	//add 검증 메서드
	//비번일치, id 중복여부
	public boolean checkMember(MemberVO memberVO,BindingResult bindingResult)throws Exception {
		boolean check = false;
		//check 가 true라면 에러가 있다..
		//check 가 false라면 에러가 없다..
		
		//annotation 검증 결과
		check=bindingResult.hasErrors();
		
		//비번 검증
		if(!memberVO.getPassword().equals(memberVO.getPasswordCheck())) {
			check = true;
			bindingResult.rejectValue("passwordCheck", "memberVO.password.equals");
		}
		//id 중복
		MemberVO result = memberDAO.getDetail(memberVO);
		if(result!=null) {
			check = true;
			bindingResult.rejectValue("username", "memberVO.username.equals");
		}		
		
		return check;
	}
}