package com.Beom.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.Beom.app.board.FileVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component("fileDownView")
@Slf4j
public class FileDownView extends AbstractView {
	@Value("${app.upliad.basePath}")
	private String base;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			log.info("===============file Done View=================");
			log.info("==========={}==============",model);
			log.info("============={}===========",request.getRequestURI());
			
			FileVO fileVO = (FileVO)model.get("fileVO");
			
			//model.keySet().iterator(); 키를 모를때
			
			String uri = request.getRequestURI();
			//파일명 notice/
			uri = uri.substring(1, uri.lastIndexOf("/")+1);
			
			File file = new File(base+uri,fileVO.getFileName());
			
			//응답시 한글처리
			response.setCharacterEncoding("UTF-8");
			
			//총 파일 크기
			response.setContentLengthLong(file.length());
			
			//한글 파일명 인고딩
			String oriName = URLEncoder.encode(fileVO.getOriName(),"UTF-8");
			
			//Header 설정
			response.setHeader("Content-Disposition", "attachment;filename=\""+oriName+"\"");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			//server의 HDD에서 파일을 읽어 오는 작업
			FileInputStream fi = new FileInputStream(file);
			
			//읽어 온 파일을 client로 전송
			OutputStream os = response.getOutputStream();
			
			//읽어온 파일 FileInputStream을 OutputStream로 전송 
			FileCopyUtils.copy(fi, os);
			
			//자원 해제
			
			os.close();
			fi.close();
			
			
			
		
	}
}
