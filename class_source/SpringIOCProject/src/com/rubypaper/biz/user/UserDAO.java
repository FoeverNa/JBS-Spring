package com.rubypaper.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.rubypaper.biz.common.JDBCUtil;

// DAO(Data Access Object) 클래스
@Repository
public class UserDAO {
	// JDBC 관련 변수 선언
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// USERS 테이블 관련 SQL 명령어
	private static final String USER_INSERT = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
	private static final String USER_GET    = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";

	// USERS 테이블 관련 CRUD 기능의 메소드
	// 회원 등록
	public void insertUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				// 검색 결과 한 건을 UserVO 객체에 매핑한다.
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}	
}




