package polymorphism4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// <bean class="polymorphism4.LgTV"></bean>
@Component("tv")
public class LgTV implements TV {
	// @Autowired : Type Injection
	// 변수의 타입을 기준으로 의존성 주입을 처리한다.
	// 해당 타입의 객체가 메모리에 있기만 하면 컨테이너가 그 객체를 변수에 할당한다.
	// 만약 주입할 객체가 없으면 Exception 발생 한다 
	@Autowired
	private Speaker speaker;
	
	
    public LgTV() {
        System.out.println("===> LgTV 생성");
    }
    @Override
    public void powerOn() {
        System.out.println("LgTV---전원 켠다.");
    }
    @Override
    public void powerOff() {
        System.out.println("LgTV---전원 끈다.");
    }
	@Override
	public void volumeUp() {
		speaker.volumeUp();	
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}

}
