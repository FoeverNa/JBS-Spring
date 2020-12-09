package com.rubypaper.biz.board;

public class InsertBoardTest {

	public static void main(String[] args) {
		//1. 글 등록 기능 처리
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setTitle("VO 테스트");
		vo.setWriter("테스터");
		vo.setContent("VO 내용.........");
		boardDAO.insertBoard(vo);
		
		// 2. 글 목럭 검색 기능 처리
		boardDAO.getBoardList();
		

		/*
		 * Connection conn = null; PreparedStatement stmt = null;
		 * 
		 * try { // 1. 드라이버 객체를 메모리에 로딩한다 JDBCUtil.getConnetion();
		 * 
		 * // 2. 커넥션을 획득한다 String url = "jdbc:h2:tcp://localhost/~/test"; conn =
		 * DriverManager.getConnection(url, "sa", "");
		 * 
		 * // 3. SQL전달 객체(Statement)를 생성한다. String sql =
		 * "insert into board(seq, title, writer, content) " +
		 * "values((select nvl(max(seq), 0) +1 from board), ?, ?, ?)"; stmt =
		 * conn.prepareStatement(sql);
		 * 
		 * // 파라미터 셋팅 stmt.setString(1, "JDBC 제목"); stmt.setString(2, "테스터");
		 * stmt.setString(3, "JDBC 내용.......");
		 * 
		 * // 4. SQL을 전송한다 int cnt = stmt.executeUpdate(); System.out.println(cnt +
		 * "건의 데이터 처리 성공!!");
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } finally { JDBCUtil.close(stmt, conn); }
		 */
	}
}
