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
		System.out.println("<사후 처리> 비지니스 메소드 리턴값 : " + returnObj.toString());
	
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if(user.getRole().equals("ADMIN")) {
				System.out.println(user.getName() + "님은 관리자 화면으로 바로 이동...");
			}
		}
	
	}
}
