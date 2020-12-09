package polymorphism4;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;
	
	
    public SamsungTV() {
        System.out.println("===> SamsungTv(1) ����");

    }
    
    
//    public SamsungTV(Speaker speaker) {
//    	System.out.println("===> SamsungTv(2) ����");
//		this.speaker = speaker;
//	}
//    
//    public SamsungTV(Speaker speaker, int price) {
//    	System.out.println("===> SamsungTv(3) ����");
//		this.speaker = speaker;
//		this.price = price;
//	}



	public void setSpeaker(Speaker speaker) {
		System.out.println("speaker setter ȣ��");
		this.speaker = speaker;
	}


	public void setPrice(int price) {
		System.out.println("price setter ȣ��");
		this.price = price;
	}

    @Override
	public void powerOn() {
        System.out.println("SamsungTv---���� �Ҵ�." + price);
    }
    @Override
	public void powerOff() {
        System.out.println("SamsungTv---���� ����.");
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
