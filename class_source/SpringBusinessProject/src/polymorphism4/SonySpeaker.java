package polymorphism4;

public class SonySpeaker implements Speaker {
	
	public SonySpeaker() {
		System.out.println("===> SonySpeaker ����");
	}
	
    
	public void volumeUp() {
        System.out.println("SonySpeaker---�Ҹ� �ø���.");
    }
    
	public void volumeDown() {
        System.out.println("SonySpeaker---�Ҹ� ������.");
    }
}
