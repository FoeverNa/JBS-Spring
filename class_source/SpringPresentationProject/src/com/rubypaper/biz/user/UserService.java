package com.rubypaper.biz.user;

// Service �������̽�
public interface UserService {

	// USERS ���̺� ���� CRUD ����� �޼ҵ�
	// ȸ�� ���
	void insertUser(UserVO vo);

	// ȸ�� �� ��ȸ
	UserVO getUser(UserVO vo);

}