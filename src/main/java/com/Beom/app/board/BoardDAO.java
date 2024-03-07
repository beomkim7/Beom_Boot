package com.Beom.app.board;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.Beom.app.util.Pager;

public interface BoardDAO {
	
	public List<BoardVO> getList(Pager pager)throws Exception;
	
	public int add(BoardVO boardVO)throws Exception;
	
	public Long getTotalCount(Pager pager)throws Exception;
	
	public int addFile(FileVO fileVO)throws Exception;
	
	public BoardVO getDetail(BoardVO boardVO)throws Exception;
	
	public FileVO getFileDetail(FileVO fileVO)throws Exception;
	
	
}
