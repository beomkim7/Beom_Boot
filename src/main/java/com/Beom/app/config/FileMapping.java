package com.Beom.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration //***-context.xml   //
public class FileMapping implements WebMvcConfigurer{
   
   @Value("${app.upload.url}")
   private String urlPath; //  /files/**  요청들러오면 컨트롤러 가지말고 filepath 주소에서 찾기
   @Value("${app.upload.base}")
   private String filePath; //  D://upload/
   //ex)files/notice/파일명 -> D://upload/notice/파일명 으로 가서 찾음
   
   
   @Override
   //외부자원으로 ??
   //ResourceHandlerRegistry에 addResourceHandlers메서드를 이용해 어느 경로로 들어왔을때 매핑이 되어줄 것인지를 정의
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      //addResourceLocations 메서드를 이용하여 실제 파일이 있는 경로를 지정
      //<resources mapping="/resources/**" location="/resources/" />
      registry.addResourceHandler(urlPath)
            .addResourceLocations(filePath);
   }
}