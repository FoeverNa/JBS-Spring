package com.rubypaper.biz.board;

public class GetBoardTest {

	public static void main(String[] args) {
		
		//1. 글 상세조회 기능 처리
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		BoardVO board = boardDAO.getBoard(vo);
		
		System.out.println(board.getSeq() + "번 게시 글의 상세 정보");
		System.out.println("제목 : " + board.getTitle());
		System.out.println("작성자 : " + board.getWriter());
		System.out.println("내용 : " + board.getContent());
		System.out.println("등록일 : " + board.getRegDate());
		System.out.println("조회수 : " + board.getCnt());

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
		 * // 5. 검색 결과 처리(SELECT 구문에 한하여...) if(rs.next()) {
		 * System.out.println("게시 글 상세 정보"); System.out.println("번호 : " +
		 * rs.getInt("SEQ") + " : "); System.out.println("제목 : " + rs.getString("TITLE")
		 * + " : "); System.out.println("작성자 : " + rs.getString("WRITER") + " : ");
		 * System.out.println("내용 : " + rs.getString("CONTENT") + " : ");
		 * System.out.println("등록일 : " + rs.getDate("REGDATE") + " : ");
		 * System.out.println("조회수 : " + rs.getInt("CNT")); }
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); } finally { // close 순서
		 * ResultSet -> Statement -> Connection try { if(rs != null) rs.close(); } catch
		 * (SQLException e1) { e1.printStackTrace(); } finally { rs = null; } try {
		 * if(stmt != null) { stmt.close(); } } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } finally { stmt = null; }
		 * try { if (conn != null && !conn.isClosed()) { conn.close(); } } catch
		 * (SQLException e) { e.printStackTrace(); } finally { conn = null; } }
		 */
	}
}
