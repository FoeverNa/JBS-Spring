package polymorphism3;

public class SonyTV implements TV {

	public SonyTV() {
		System.out.println("===> SonyTV ����");
	}

	@Override
	public void powerOn() {
		System.out.println("SonyTV---���� �Ҵ�.");
	}

	@Override
	public void powerOff() {
		System.out.println("SonyTV---���� ����.");
	}

	@Override
	public void volumeUp() {
		System.out.println("SonyTV---�Ҹ� �ø���.");
	}

	@Override
	public void volumeDown() {
		System.out.println("SonyTV---�Ҹ� ������.");
	}

}