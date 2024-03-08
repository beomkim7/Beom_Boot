package com.Beom.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class seviceLogger {
	//공통로직 Advise
	
	@Around("execution(* com.Beom.app.**.*service*.*(..))")
	public Object log(ProceedingJoinPoint joinPoint)throws Throwable{
		log.info("=============service실행===============");
		
		log.info("=====매개변수:{}",joinPoint.getArgs());
		
		Object object = joinPoint.proceed();
		
		log.info("==============service종료==============");
		
		return object;
	}
}	
