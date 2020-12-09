package polymorphism4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// <bean class="polymorphism4.LgTV"></bean>
@Component("tv")
public class LgTV implements TV {
	// @Autowired : Type Injection
	// ������ Ÿ���� �������� ������ ������ ó���Ѵ�.
	// �ش� Ÿ���� ��ü�� �޸𸮿� �ֱ⸸ �ϸ� �����̳ʰ� �� ��ü�� ������ �Ҵ��Ѵ�.
	// ���� ������ ��ü�� ������ Exception �߻� �Ѵ� 
	@Autowired
	private Speaker speaker;
	
	
    public LgTV() {
        System.out.println("===> LgTV ����");
    }
    @Override
    public void powerOn() {
        System.out.println("LgTV---���� �Ҵ�.");
    }
    @Override
    public void powerOff() {
        System.out.println("LgTV---���� ����.");
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
