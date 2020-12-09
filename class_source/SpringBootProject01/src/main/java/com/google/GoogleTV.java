package com.google;

import org.springframework.stereotype.Service;

@Service
public class GoogleTV {
	
	public GoogleTV() {
		System.out.println("===> GoogleTV created"); // 컴포넌트 스캔했을때 생성한다
	}

}
