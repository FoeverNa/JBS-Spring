package com.rubypaper.biz.common;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {



	@AfterThrowing(pointcut = "BoardPointcut.allPointcut()", throwing="exceptionObj")
	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		String method = jp.getSignature().getName(); // 클라이언트가 호출한 메소드 이름
		
		System.out.println("[ 예외 처리] " + method + "() 메소드가 수행 중 예외 발생");
		
		System.out.println("<예외 처리> 비지니스 메서드 수행 중 예외 발생");

		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("0번 게시 글을 등록할 수는 없습니다");
		} else if(exceptionObj instanceof ArithmeticException) {
			System.out.println("0으로 숫자를 나눌 수 없습니다.");
		} else if(exceptionObj instanceof SQLException) {
			System.out.println("SQL 구문에 오류가 있습니다.");
		} else {
			System.out.println("문제발생!! 잠시 시스템을 종료합니다.");
		}
	}
}
