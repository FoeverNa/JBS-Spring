package com.rubypaper.tv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 환경설정 클래스임을 알려주는 클래스
@ComponentScan(basePackages= {"com.google"}) //요패키지로 시작하는 모든 클래스중에 @어노테이션 있다면 빈생성해준다
public class TVConfiguration {
	
	@Bean("stv")
	public SamsungTV tv() {
		SamsungTV tv = new SamsungTV();
//		tv.setSpeaker(speaker());
		return tv; // 그냥 new SamsungTV(); 해도된다
	}
	// 비지니스 레이어 대신 클래스로 환경설정한다
	
	@Bean // Autowired위해 bean으로 등록한다// 세터인젝션시에는 하지 않아도 된다
	public AppleSpeaker speaker() {
		return new AppleSpeaker();
	}

}
