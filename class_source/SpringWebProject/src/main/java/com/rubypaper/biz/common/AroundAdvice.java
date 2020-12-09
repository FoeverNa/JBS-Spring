package com.rubypaper.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

// around는 사전처리와 사후처리를 모두 할 수 있다. (서블릿의 Filter와 동일한 개념)
// 비지니스 메서드에 대한 사전처리사후처리라는 것이 다르다
@Service
@Aspect
public class AroundAdvice {

	@Around("BoardPointcut.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		String method = jp.getSignature().getName(); // 클라이언트가 호출한 메소드 이름
		
		
		Object obj = null;
		StopWatch watch = new StopWatch();
		watch.start();
		
		obj = jp.proceed();
		
		watch.stop();
		System.out.println(method  +"() 메소드 수행에 소요된 시간 : " 
				+ watch.getTotalTimeMillis() + "(ms)초");
		return obj;

	}
}
