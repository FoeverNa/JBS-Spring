package polymorphism3;

public class LgTV implements TV {
	
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
		System.out.println("LgTv---�Ҹ� �ø���.");	
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTv---�Ҹ� ������.");
	}

}
