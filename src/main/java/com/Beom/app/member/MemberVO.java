package com.Beom.app.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.Beom.app.member.goups.MemberJoinGroup;
import com.Beom.app.member.goups.MemberUpdateGroup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberVO implements UserDetails, OAuth2User {
	

	@NotBlank(message = "꼭 입력하세요", groups = {MemberJoinGroup.class, MemberUpdateGroup.class})
	private String username;
	
	@NotBlank(groups = MemberJoinGroup.class)
	@Size(min=8, max = 16,groups = MemberJoinGroup.class)
	private String password;
	
	private String passwordCheck;
	
	private String phone;
	@Email(groups = {MemberJoinGroup.class,MemberUpdateGroup.class})
	private String email;
	private String address;
	private String name;
	
	private boolean accountNonExpired; 	// 계정이 만료되었나
	private boolean accountNonLocked;	// 계정이 잠김 여부
	private boolean credentialsNonExpired; // 비밀번호 유효기간 기준으로 사용가능여부
	private boolean enabled;			// 사용불가
	
	private List<RoleVO> roleVOs;
	
	//Naver, kakao, google 무엇으로 로그인하는지 체크
	private String social;
	
	private Map<String, Object> attributes;
	
	@Override
	public Map<String, Object> getAttributes() {
	
		return this.attributes;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		for(RoleVO roleVO:this.getRoleVOs()) {
			GrantedAuthority g = new SimpleGrantedAuthority(roleVO.getRoleName());
			authorities.add(g);
		}
		return authorities;
	}
//	@Override
//	public boolean isAccountNonExpired() {
//		// 계정이 만료되었나
//		return true;
//	}
//	@Override
//	public boolean isAccountNonLocked() {
//		// 계정이 잠김 여부
//		return true;
//	}
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// 비밀번호 유효기간 기준으로 사용가능여부
//		return true;
//	}
//	@Override
//	public boolean isEnabled() {
//		// 사용불가
//		return true;
//	}
}