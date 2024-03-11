package com.Beom.app.member;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Beom.app.member.goups.MemberJoinGroup;
import com.Beom.app.member.goups.MemberUpdateGroup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberVO implements UserDetails {
	

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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// 계정이 만료되었나
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// 계정이 잠김 여부
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// 비밀번호 유효기간 기준으로 사용가능여부
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}