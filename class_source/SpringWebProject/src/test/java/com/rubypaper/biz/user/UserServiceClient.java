package com.rubypaper.biz.user;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		GenericXmlApplicationContext container =
				new GenericXmlApplicationContext("business-*.xml");
		
		UserService userService = (UserService) container.getBean("userService");
		
		UserVO vo = new UserVO();

//		vo.setId("Spring");
//		vo.setPassword("Test");
//		vo.setName("프링");
//		vo.setRole("친구");
//		
//		userService.insertUser(vo);
	
		vo.setId("admin");
		vo.setPassword("admin");
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		} else {
			System.out.println("회원 id를 확인해주세요");
		}
		
		container.close();
	
	}
	
}
