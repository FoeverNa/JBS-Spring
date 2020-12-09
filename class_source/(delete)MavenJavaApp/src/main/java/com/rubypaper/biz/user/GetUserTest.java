package com.rubypaper.biz.user;

public class GetUserTest {
	public static void main(String[] args) {
		
		//1. ȸ������ ��� �׽�Ʈ
		UserDAO userDAO = new UserDAO();
		UserVO vo = new UserVO();
		vo.setId("guest");
		vo.setPassword("guest123");
		vo.setName("�湮��");
		vo.setRole("USER");
		userDAO.insertUser(vo);
		
		// 2. ȸ�� �� ��ȸ ��� �׽�Ʈ
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "�� ȯ���մϴ�. �α��� ����!");
		} else {
			System.out.println(vo.getId() + "�α��� ����");
		}
		
//		// JDBC API ����
//		Connection conn = null;
////		Statement stmt = null;
//		PreparedStatement stmt = null; // �ڵ����ε� ���
//		ResultSet rs = null;
//		
//		
//		try {
//			// 2. Connection ��ü�� ȹ���Ѵ�.
//			conn = JDBCUtil.getConnetion();
//			
//			// 3. Statement ��ü�� ȹ���Ѵ�
//			String sql = "select * from users where id = ? and password = ?";
//			stmt = conn.prepareStatement(sql);
//			
//			//?(�Ķ����)�� �� ����
//			stmt.setString(1, "admin");
//			stmt.setString(2, "admin");
//			
//			// 4. SQL ������ DB�� �����Ѵ�.
//			rs = stmt.executeQuery();
//			
//			// 5. �˻� ��� ó��
//			if(rs.next()) {
//				System.out.println("���̵� : " + rs.getString("ID"));
//				System.out.println("��� : " + rs.getString("PASSWORD"));
//				System.out.println("�̸� : " + rs.getString("NAME"));
//				System.out.println("���� : " + rs.getString("ROLE"));
//			}
//		
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(rs, stmt, conn);
//		}
//		
	}

}
