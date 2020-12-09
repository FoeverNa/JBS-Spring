package com.rubypaper.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

// around�� ����ó���� ����ó���� ��� �� �� �ִ�. (������ Filter�� ������ ����)
// �����Ͻ� �޼��忡 ���� ����ó������ó����� ���� �ٸ���
@Service
@Aspect
public class AroundAdvice {

	@Around("BoardPointcut.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		String method = jp.getSignature().getName(); // Ŭ���̾�Ʈ�� ȣ���� �޼ҵ� �̸�
		
		
		Object obj = null;
		StopWatch watch = new StopWatch();
		watch.start();
		
		obj = jp.proceed();
		
		watch.stop();
		System.out.println(method  +"() �޼ҵ� ���࿡ �ҿ�� �ð� : " 
				+ watch.getTotalTimeMillis() + "(ms)��");
		return obj;

	}
}
