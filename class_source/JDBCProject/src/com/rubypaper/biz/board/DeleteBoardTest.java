package com.rubypaper.biz.board;

public class DeleteBoardTest {

	public static void main(String[] args) {

		//1. �� ��� ��� ó��
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setSeq(2);
		boardDAO.deleteBoard(vo);
		
		// 2. �� �� �˻� ��� ó��
		boardDAO.getBoardList();
		
		/*
		 * Connection conn = null; Statement stmt = null;
		 * 
		 * try { // 1. ����̹� ��ü�� �޸𸮿� �ε��Ѵ� DriverManager.registerDriver(new
		 * org.h2.Driver()); // Class.forName("new org.h2.Driver()");
		 * 
		 * // 2. Ŀ�ؼ��� ȹ���Ѵ� String url = "jdbc:h2:tcp://localhost/~/test"; conn =
		 * DriverManager.getConnection(url, "sa", "");
		 * 
		 * // 3. SQL���� ��ü(Statement)�� �����Ѵ�. stmt = conn.createStatement();
		 * 
		 * // 4. SQL�� �����Ѵ� String sql = "delete board where seq = 3"; int cnt =
		 * stmt.executeUpdate(sql); System.out.println(cnt + "���� ������ ó�� ����!!");
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } finally { try { if(stmt != null) { stmt.close(); } }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } finally { stmt = null; } try { if (conn != null &&
		 * !conn.isClosed()) { conn.close(); } } catch (SQLException e) {
		 * e.printStackTrace(); } finally { conn = null; } }
		 */
	}
}
