package polymorphism4;

public class SonySpeaker implements Speaker {
	
	public SonySpeaker() {
		System.out.println("===> SonySpeaker 积己");
	}
	
    
	public void volumeUp() {
        System.out.println("SonySpeaker---家府 棵赴促.");
    }
    
	public void volumeDown() {
        System.out.println("SonySpeaker---家府 郴赴促.");
    }
}
