package com.rubypaper.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	public static Connection getConnection() {
		try {
			// 1. 드라이버 객체를 메모리에 로딩한다.
			Class.forName("org.h2.Driver");

			// 2. Connection 객체를 획득한다.
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// SELECT 기능의 자원 해제
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		// close 순서 ResultSet -> Statement -> Connection
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}

		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}

		try {
			if (!conn.isClosed() && conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

	// Not SELECT 기능의 자원 해제
	public static void close(PreparedStatement stmt, Connection conn) {
		// close 순서 Statement -> Connection
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}

		try {
			if (!conn.isClosed() && conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

}
