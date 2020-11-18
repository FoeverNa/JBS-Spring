package com.rubypaper.biz.board;

public class UpdateBoardTest {

	public static void main(String[] args) {
		//1. 글 수정 기능 처리
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setTitle("수정 내용");
		vo.setWriter("수정 제목");
		vo.setSeq(2);
		boardDAO.updateBoard(vo);
		
		// 2. 글 상세 조회 기능 처리
		boardDAO.getBoard(vo);
		
		/*
		 * Connection conn = null; Statement stmt = null;
		 * 
		 * try { // 1. 드라이버 객체를 메모리에 로딩한다 DriverManager.registerDriver(new
		 * org.h2.Driver()); // Class.forName("new org.h2.Driver()");
		 * 
		 * // 2. 커넥션을 획득한다 String url = "jdbc:h2:tcp://localhost/~/test"; conn =
		 * DriverManager.getConnection(url, "sa", "");
		 * 
		 * // 3. SQL전달 객체(Statement)를 생성한다. stmt = conn.createStatement();
		 * 
		 * // 4. SQL을 전송한다 String sql =
		 * "UPDATE board set title ='제목 수정', content = '내용 수정' where seq=1"; int cnt =
		 * stmt.executeUpdate(sql); System.out.println(cnt + "건의 데이터 처리 성공!!");
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
