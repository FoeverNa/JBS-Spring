package com.rubypaper.biz.user;

public interface UserDAO {

	// USERS ���̺� ���� CRUD ����� �޼ҵ�
	// ȸ�� ���
	void insertUser(UserVO vo);

	// ȸ�� �� ��ȸ
	UserVO getUser(UserVO vo);

}