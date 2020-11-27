package com.rubypaper.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service 구현클래스
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void insertUser(UserVO vo) {
		System.out.println("===> JDBC 기반으로 insertUser() 기능 처리");
		userDAO.insertUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC 기반으로 getUser() 기능 처리");
		return userDAO.getUser(vo);
	}

}
