package com.rubypaper.biz.board;

import java.util.List;

public class GetBoardListTest {

	public static void main(String[] args) {

		//1. �� ��� ��ȸ ��� ó��
		BoardDAO boardDAO = new BoardDAO();
		
		// getBoardList() �޼ҵ尡 ������ �� ����� ���ϴ� ���·� ����Ѵ�
		List<BoardVO> boardList = boardDAO.getBoardList();
		
		
		  // 1. CASE 
//		  System.out.println("[ BOARD LIST ]"); 
//		  for (BoardVO board : boardList) {
//			  System.out.println("---> " + board.toString()); }
//		 
		
		// 2. CASE
		System.out.println("�˻��� �Խñ� �� : " + boardList.size());
				
		
		/*
		 * Connection conn = null; Statement stmt = null; ResultSet rs = null;
		 * 
		 * try { // 1. ����̹� ��ü�� �޸𸮿� �ε��Ѵ� DriverManager.registerDriver(new
		 * org.h2.Driver()); // Class.forName("new org.h2.Driver()");
		 * 
		 * // 2. Ŀ�ؼ��� ȹ���Ѵ� String url = "jdbc:h2:tcp://localhost/~/test"; conn =
		 * DriverManager.getConnection(url, "sa", "");
		 * 
		 * // 3. SQL���� ��ü(Statement)�� �����Ѵ�. stmt = conn.createStatement();
		 * 
		 * // 4. SQL�� �����Ѵ� String sql = "select * from board order by seq desc"; rs =
		 * stmt.executeQuery(sql);
		 * 
		 * // 5. �˻� ��� ó��(SELECT ������ ���Ͽ�...) System.out.println("[ BOARD LIST ]");
		 * while(rs.next()) { System.out.print(rs.getInt("SEQ") + " : ");
		 * System.out.print(rs.getString("TITLE") + " : ");
		 * System.out.print(rs.getString("WRITER") + " : ");
		 * System.out.print(rs.getString("CONTENT") + " : ");
		 * System.out.print(rs.getDate("REGDATE") + " : ");
		 * System.out.println(rs.getInt("CNT")); }
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } finally { // close ���� ResultSet -> Statement ->
		 * Connection try { if(rs != null) rs.close(); } catch (SQLException e1) {
		 * e1.printStackTrace(); } finally { rs = null; } try { if(stmt != null) {
		 * stmt.close(); } } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } finally { stmt = null; } try { if (conn != null &&
		 * !conn.isClosed()) { conn.close(); } } catch (SQLException e) {
		 * e.printStackTrace(); } finally { conn = null; } }
		 */
	}
}
