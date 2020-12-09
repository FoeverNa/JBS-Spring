package com.rubypaper.biz.user;

// Service 인터페이스
public interface UserService {

	// USERS 테이블 관련 CRUD 기능의 메소드
	// 회원 등록
	void insertUser(UserVO vo);

	// 회원 상세 조회
	UserVO getUser(UserVO vo);

}