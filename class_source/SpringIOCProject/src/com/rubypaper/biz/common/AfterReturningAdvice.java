package com.rubypaper.biz.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.rubypaper.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {

	
	@AfterReturning(pointcut="BoardPointcut.getPointcut()", returning="returnObj")
	public void afterLog(Object returnObj) {
		System.out.println("<���� ó��> �����Ͻ� �޼ҵ� ���ϰ� : " + returnObj.toString());
	
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("ADMIN")) {
				System.out.println(user.getName() + "���� ������ ȭ������ �ٷ� �̵�...");
			}
		}
	
	}
}
