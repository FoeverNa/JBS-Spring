package polymorphism4;

public class AppleSpeaker implements Speaker {
		
	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker ����");
	}
	
    
	@Override
	public void volumeUp() {
        System.out.println("AppleSpeaker---�Ҹ� �ø���.");
    }
    
	@Override
	public void volumeDown() {
        System.out.println("AppleSpeaker---�Ҹ� ������.");
    }
}
