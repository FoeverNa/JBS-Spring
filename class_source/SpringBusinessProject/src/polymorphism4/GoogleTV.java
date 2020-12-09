package polymorphism4;

public class GoogleTV implements TV {

	private int price;
	
	public GoogleTV() {
		System.out.println("===> GoogleTV 생성");
	}	
		
	public void 멤버변수초기화() {
		System.out.println("---> 멤버변수초기화() 호출");
		this.price = 1200000;
	}
	
	public void 자원해제() {
		System.out.println("---> 자원해제() 호출");
		this.price = 0;
	}

	@Override
	public void powerOn() {
		System.out.println("GoogleTV---전원 켠다."+price);
	}

	@Override
	public void powerOff() {
		System.out.println("GoogleTV---전원 끈다.");
	}

	@Override
	public void volumeUp() {
		System.out.println("GoogleTV---소리 올린다.");
	}

	@Override
	public void volumeDown() {
		System.out.println("SonyTV---소리 내린다.");
	}

}