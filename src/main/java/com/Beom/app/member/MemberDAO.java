package com.Beom.app.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {//MemberMapper
	
	public MemberVO getDetail(MemberVO memberVO)throws Exception;
	public int add(MemberVO memberVO)throws Exception;
	
}
