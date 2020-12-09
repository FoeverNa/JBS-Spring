package com.rubypaper.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

// DAO(Data Access Object) Ŭ����
//@Repository
public class UserDAOMyBATIS implements UserDAO {

	@Autowired
	SqlSessionTemplate myBatis;
	//SqlSession�� �������̽��� ��ü������ �ȵȴ�


	// USERS ���̺� ���� CRUD ����� �޼ҵ�
	// ȸ�� ���
	public void insertUser(UserVO vo) {
		System.out.println("===> MyBatis ������� insertUser() ��� ó��");
		
		myBatis.insert("UserDAO.insertUser", vo);
	}
	
	// ȸ�� �� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> MyBatis ������� getUser() ��� ó��");
		
		return  (UserVO) myBatis.selectOne("UserDAO.getUser", vo);
		
	}	
}




