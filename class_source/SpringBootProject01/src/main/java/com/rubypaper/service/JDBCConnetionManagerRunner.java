package com.rubypaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.jdbc.util.JDBCConnectionManager;

@Service
public class JDBCConnetionManagerRunner implements ApplicationRunner {

	@Autowired
	private JDBCConnectionManager manager;
	
	public JDBCConnetionManagerRunner() {
		System.out.println("===> JDBCConnetionManagerRunner 생성");
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception { //이객체가 메모리에뜨는순간 실행되는 메소드
		System.out.println("커넥션 매니저: " + manager.toString());

	}

}
