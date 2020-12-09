package com.rubypaper.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// DAO(Data Access Object) 클래스
//@Repository
public class UserDAOSpring implements UserDAO {

	@Autowired
	JdbcTemplate spring;

	// USERS 테이블 관련 SQL 명령어
	private static final String USER_INSERT = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
	private static final String USER_GET    = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";

	// USERS 테이블 관련 CRUD 기능의 메소드
	// 회원 등록
	public void insertUser(UserVO vo) {
		System.out.println("===> Spring 기반으로 insertUser() 기능 처리");
//		Object[] args= {vo.getId(),vo.getPassword(),vo.getName(),vo.getRole()};
		spring.update(USER_INSERT,vo.getId(),vo.getPassword(),vo.getName(),vo.getRole());		
	}
	
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring 기반으로 getUser() 기능 처리");
		Object[] args = {vo.getId(), vo.getPassword()};
		return spring.queryForObject(USER_GET, args, new UserRowMapper());
		
	}	
}




