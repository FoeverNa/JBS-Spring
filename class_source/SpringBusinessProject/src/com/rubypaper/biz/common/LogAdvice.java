package com.rubypaper.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect // Aspect= Pointcut + Advice

public class LogAdvice {
	
	@Before("BoardPointcut.allPointcut()")
	public void printLog(JoinPoint jp) {
		String method = jp.getSignature().getName(); // 클라이언트가 호출한 메소드 이름
		Object[] args = jp.getArgs(); // 클라이언트가 전달한 인자 정보
		
		
		System.out.println("<사전 처리>" + method
				+ "() 메소드 ARGS 정보: " + args[0].toString());
	
	}
}
