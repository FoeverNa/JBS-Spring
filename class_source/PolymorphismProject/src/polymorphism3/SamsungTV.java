package polymorphism3;

public class SamsungTV implements TV {
	
    public SamsungTV() {
        System.out.println("===> SamsungTv ����");
    }

    @Override
	public void powerOn() {
        System.out.println("SamsungTv---���� �Ҵ�.");
    }
    @Override
	public void powerOff() {
        System.out.println("SamsungTv---���� ����.");
    }
    @Override
	public void volumeUp() {
        System.out.println("SamsungTv---�Ҹ� �ø���.");
    }
    @Override
	public void volumeDown() {
        System.out.println("SamsungTv---�Ҹ� ������.");
    }

}
