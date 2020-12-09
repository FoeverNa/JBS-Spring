package com.rubypaper.tv;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungTV {

	@Autowired
	private AppleSpeaker speaker;

	public SamsungTV() {

		System.out.println("===> SamsungTv 생성");
	}
	

//	public void setSpeaker(AppleSpeaker speaker) { // 세터 인젝션 연습용
//		this.speaker = speaker;
//	} 


	public void powerOn() {
		System.out.println("SamsungTv--- powerOn ");
	}

	public void powerOff() {
		System.out.println("SamsungTv--- powerOff ");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
