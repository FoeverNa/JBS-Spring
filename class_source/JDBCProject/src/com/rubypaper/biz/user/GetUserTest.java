package com.rubypaper.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rubypaper.biz.common.JDBCUtil;

public class GetUserTest {
	public static void main(String[] args) {
		// JDBC API ����
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement stmt = null; // �ڵ����ε� ���
		ResultSet rs = null;
		
		
		try {
			// 2. Connection ��ü�� ȹ���Ѵ�.
			conn = JDBCUtil.getConnetion();
			
			// 3. Statement ��ü�� ȹ���Ѵ�
			String sql = "select * from users where id = ? and password = ?";
			stmt = conn.prepareStatement(sql);
			
			//?(�Ķ����)�� �� ����
			stmt.setString(1, "admin");
			stmt.setString(2, "admin");
			
			// 4. SQL ������ DB�� �����Ѵ�.
			rs = stmt.executeQuery();
			
			// 5. �˻� ��� ó��
			if(rs.next()) {
				System.out.println("���̵� : " + rs.getString("ID"));
				System.out.println("��� : " + rs.getString("PASSWORD"));
				System.out.println("�̸� : " + rs.getString("NAME"));
				System.out.println("���� : " + rs.getString("ROLE"));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		
	}

}
