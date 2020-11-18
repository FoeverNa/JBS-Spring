package com.rubypaper.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rubypaper.biz.common.JDBCUtil;

public class GetUserTest {
	public static void main(String[] args) {
		// JDBC API 선언
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement stmt = null; // 자동차인데 페라리
		ResultSet rs = null;
		
		
		try {
			// 2. Connection 객체를 획득한다.
			conn = JDBCUtil.getConnetion();
			
			// 3. Statement 객체를 획득한다
			String sql = "select * from users where id = ? and password = ?";
			stmt = conn.prepareStatement(sql);
			
			//?(파라미터)에 값 설정
			stmt.setString(1, "admin");
			stmt.setString(2, "admin");
			
			// 4. SQL 구문을 DB에 전송한다.
			rs = stmt.executeQuery();
			
			// 5. 검색 결과 처리
			if(rs.next()) {
				System.out.println("아이디 : " + rs.getString("ID"));
				System.out.println("비번 : " + rs.getString("PASSWORD"));
				System.out.println("이름 : " + rs.getString("NAME"));
				System.out.println("권한 : " + rs.getString("ROLE"));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		
	}

}
