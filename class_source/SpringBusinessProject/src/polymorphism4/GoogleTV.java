package polymorphism4;

public class GoogleTV implements TV {

	private int price;
	
	public GoogleTV() {
		System.out.println("===> GoogleTV ����");
	}	
		
	public void ��������ʱ�ȭ() {
		System.out.println("---> ��������ʱ�ȭ() ȣ��");
		this.price = 1200000;
	}
	
	public void �ڿ�����() {
		System.out.println("---> �ڿ�����() ȣ��");
		this.price = 0;
	}

	@Override
	public void powerOn() {
		System.out.println("GoogleTV---���� �Ҵ�."+price);
	}

	@Override
	public void powerOff() {
		System.out.println("GoogleTV---���� ����.");
	}

	@Override
	public void volumeUp() {
		System.out.println("GoogleTV---�Ҹ� �ø���.");
	}

	@Override
	public void volumeDown() {
		System.out.println("SonyTV---�Ҹ� ������.");
	}

}