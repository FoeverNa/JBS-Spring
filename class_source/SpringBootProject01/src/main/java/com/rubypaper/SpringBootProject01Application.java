package com.rubypaper;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootConfiguration // @Configuration이랑 똑같다. 바꾸어 실행해도 똑같이 실행가능하다 
//@EnableAutoConfiguration // 엄청 중요한 어노테이션 
	//내가 만들지 않은 클래스드들을 자동으로 로딩해주는 기능
		// autoconfigure에 속하며 spring.factories라는 프로퍼티에서 자동설정 클래스들을 띄운다
		// 그중에서 WEbMvcAutoConfiguration을 보니 3가지 조건을 만족해야되고 선,후 설정파일들을 지정해놨다 
		// 내가만들어서 띄울수도 있다
//@ComponentScan // <contxt:component-scan bae-package="com.rubypaper"> 와 똑같다! 메인클래스가 속해있는 패키지를 베이스 배키지로 처린한다
	//@ConponentScan(basePackages={"com.rubypaper", "com.ruby"}) 이렇게 해야 모두 스캔 하게 된다
	// @Configuration @Repository @Service @controller @ResController 가 붙은 클래스의 객체를 생성하는 역할을 한다
@SpringBootApplication // 위의 3개가 포함된 어노테이션, 3개만 써줘도 동작이 가능하다
public class SpringBootProject01Application {
//	WebMvcAutoConfiguration
	public static void main(String[] args) {
//		SpringApplication.run(SpringBootProject01Application.class, args); // SERVLET
		
		SpringApplication application = new SpringApplication(SpringBootProject01Application.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);// NONE or SERVLET
		application.setBannerMode(Banner.Mode.OFF);//properti none으로 해놓고 실행, OFF로 하면 콘솔에 배너가출력되지 않음
		application.run(args);
	}

}
