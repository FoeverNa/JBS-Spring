package polymorphism4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		// 1. 스프링 IoC(Inversion of Control) 컨테이너를 생성(구동)한다.
		GenericXmlApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
//		BeanFactory factory = new BeanFactory();

		// 2. 스프링 Ioc 컨테이너로부터 객체를 검색(Lookup)한다. 
				
		TV tv = (TV) container.getBean("tv");
//		TV tv2 = (TV) container.getBean("tv");
//		TV tv3 = (TV) container.getBean("tv");
//		System.out.println(tv1.toString());
//		System.out.println(tv2.toString());
//		System.out.println(tv3.toString());
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. 스프링 IoC 컨테이너를 종료한다.(컨테이너는 종료되기 직전에 자신이 관리하던 모든 객체를 삭제한다.)
		container.close();
	}
}
