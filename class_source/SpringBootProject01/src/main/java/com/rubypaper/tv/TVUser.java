package com.rubypaper.tv;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUser {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext container =
//				new AnnotationConfigApplicationContext(TVConfiguration.class); // 컨피규레이션 클래스를 직접 지정해주는 방법
				new AnnotationConfigApplicationContext("com.rubypaper.tv"); // 환경설정을 패키지로 해서 여러클래스를 읽을 수도 있다
																			// 그러기 위해선 @Configruation 어노테이션 설정이 되어있어야 한다
		
//		GenericXmlApplicationContext container =
//				new GenericXmlApplicationContext("business-layer.xml"); // 비지니스레이어 삭제하고 이것도 주석
		
		SamsungTV tv = (SamsungTV) container.getBean("stv");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		container.close();
	}

}
