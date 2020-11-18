package polymorphism3;

public class SonyTV implements TV {

	public SonyTV() {
		System.out.println("===> SonyTV 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("SonyTV---전원 켠다.");
	}

	@Override
	public void powerOff() {
		System.out.println("SonyTV---전원 끈다.");
	}

	@Override
	public void volumeUp() {
		System.out.println("SonyTV---소리 올린다.");
	}

	@Override
	public void volumeDown() {
		System.out.println("SonyTV---소리 내린다.");
	}

}