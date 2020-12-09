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
		String method = jp.getSignature().getName(); // Ŭ���̾�Ʈ�� ȣ���� �޼ҵ� �̸�
		Object[] args = jp.getArgs(); // Ŭ���̾�Ʈ�� ������ ���� ����
		
		
		System.out.println("<���� ó��>" + method
				+ "() �޼ҵ� ARGS ����: " + args[0].toString());
	
	}
}
