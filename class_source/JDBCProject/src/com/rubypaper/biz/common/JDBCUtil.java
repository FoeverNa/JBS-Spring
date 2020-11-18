package com.rubypaper.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	public static Connection getConnetion() {
		try {
			// 1. ����̹� ��ü�� �޸𸮿� �ε��Ѵ�.
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;		
		
	}

	//SELECT ����� �ڿ� ����
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
					try {
						if(rs != null)
							rs.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					finally {
						rs = null;
					}
					try {
						if(stmt != null) {
							stmt.close();	
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					finally {
						stmt = null;
					}
					try {
						if (conn != null && !conn.isClosed()) {
							conn.close();	
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					finally {
						conn = null;
					}
		
	}
	// Not SELECT ����� �ڿ� ����
	public static void close(PreparedStatement stmt, Connection conn) {
					try {
						if(stmt != null) {
							stmt.close();	
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					finally {
						stmt = null;
					}
					try {
						if (conn != null && !conn.isClosed()) {
							conn.close();	
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					finally {
						conn = null;
					}
		
	}
}
