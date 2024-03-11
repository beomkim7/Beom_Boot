package com.Beom.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	//삭제할 메서드. . .
	public MemberVO detail() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername("mym9211");
		return memberDAO.getDetail(memberVO);
	}
	
	public int add(MemberVO memberVO)throws Exception{
		int result = memberDAO.add(memberVO);
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