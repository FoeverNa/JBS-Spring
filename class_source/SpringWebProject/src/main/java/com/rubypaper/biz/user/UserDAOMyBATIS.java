package com.rubypaper.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

// DAO(Data Access Object) 클래스
//@Repository
public class UserDAOMyBATIS implements UserDAO {

	@Autowired
	SqlSessionTemplate myBatis;
	//SqlSession은 인터페이스라 객체생성이 안된다


	// USERS 테이블 관련 CRUD 기능의 메소드
	// 회원 등록
	public void insertUser(UserVO vo) {
		System.out.println("===> MyBatis 기반으로 insertUser() 기능 처리");
		
		myBatis.insert("UserDAO.insertUser", vo);
	}
	
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> MyBatis 기반으로 getUser() 기능 처리");
		
		return  (UserVO) myBatis.selectOne("UserDAO.getUser", vo);
		
	}	
}




