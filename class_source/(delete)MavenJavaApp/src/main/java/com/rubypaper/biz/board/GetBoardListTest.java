package com.rubypaper.biz.board;

import java.util.List;

public class GetBoardListTest {

	public static void main(String[] args) {

		//1. 글 목록 조회 기능 처리
		BoardDAO boardDAO = new BoardDAO();
		
		// getBoardList() 메소드가 리턴한 글 목록을 원하는 형태로 사용한다
		List<BoardVO> boardList = boardDAO.getBoardList();
		
		
		  // 1. CASE 
//		  System.out.println("[ BOARD LIST ]"); 
//		  for (BoardVO board : boardList) {
//			  System.out.println("---> " + board.toString()); }
//		 
		
		// 2. CASE
		System.out.println("검색된 게시글 수 : " + boardList.size());
				
		
		/*
		 * Connection conn = null; Statement stmt = null; ResultSet rs = null;
		 * 
		 * try { // 1. 드라이버 객체를 메모리에 로딩한다 DriverManager.registerDriver(new
		 * org.h2.Driver()); // Class.forName("new org.h2.Driver()");
		 * 
		 * // 2. 커넥션을 획득한다 String url = "jdbc:h2:tcp://localhost/~/test"; conn =
		 * DriverManager.getConnection(url, "sa", "");
		 * 
		 * // 3. SQL전달 객체(Statement)를 생성한다. stmt = conn.createStatement();
		 * 
		 * // 4. SQL을 전송한다 String sql = "select * from board order by seq desc"; rs =
		 * stmt.executeQuery(sql);
		 * 
		 * // 5. 검색 결과 처리(SELECT 구문에 한하여...) System.out.println("[ BOARD LIST ]");
		 * while(rs.next()) { System.out.print(rs.getInt("SEQ") + " : ");
		 * System.out.print(rs.getString("TITLE") + " : ");
		 * System.out.print(rs.getString("WRITER") + " : ");
		 * System.out.print(rs.getString("CONTENT") + " : ");
		 * System.out.print(rs.getDate("REGDATE") + " : ");
		 * System.out.println(rs.getInt("CNT")); }
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } finally { // close 순서 ResultSet -> Statement ->
		 * Connection try { if(rs != null) rs.close(); } catch (SQLException e1) {
		 * e1.printStackTrace(); } finally { rs = null; } try { if(stmt != null) {
		 * stmt.close(); } } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } finally { stmt = null; } try { if (conn != null &&
		 * !conn.isClosed()) { conn.close(); } } catch (SQLException e) {
		 * e.printStackTrace(); } finally { conn = null; } }
		 */
	}
}
