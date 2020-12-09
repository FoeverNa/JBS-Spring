package com.rubypaper.biz.user;

public interface UserDAO {

	// USERS 테이블 관련 CRUD 기능의 메소드
	// 회원 등록
	void insertUser(UserVO vo);

	// 회원 상세 조회
	UserVO getUser(UserVO vo);

}