package com.rubypaper.biz.board;

public class InsertBoardTest {

	public static void main(String[] args) {
		//1. �� ��� ��� ó��
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setTitle("VO �׽�Ʈ");
		vo.setWriter("�׽���");
		vo.setContent("VO ����.........");
		boardDAO.insertBoard(vo);
		
		// 2. �� �� �˻� ��� ó��
		boardDAO.getBoardList();
		

		/*
		 * Connection conn = null; PreparedStatement stmt = null;
		 * 
		 * try { // 1. ����̹� ��ü�� �޸𸮿� �ε��Ѵ� JDBCUtil.getConnetion();
		 * 
		 * // 2. Ŀ�ؼ��� ȹ���Ѵ� String url = "jdbc:h2:tcp://localhost/~/test"; conn =
		 * DriverManager.getConnection(url, "sa", "");
		 * 
		 * // 3. SQL���� ��ü(Statement)�� �����Ѵ�. String sql =
		 * "insert into board(seq, title, writer, content) " +
		 * "values((select nvl(max(seq), 0) +1 from board), ?, ?, ?)"; stmt =
		 * conn.prepareStatement(sql);
		 * 
		 * // �Ķ���� ���� stmt.setString(1, "JDBC ����"); stmt.setString(2, "�׽���");
		 * stmt.setString(3, "JDBC ����.......");
		 * 
		 * // 4. SQL�� �����Ѵ� int cnt = stmt.executeUpdate(); System.out.println(cnt +
		 * "���� ������ ó�� ����!!");
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } finally { JDBCUtil.close(stmt, conn); }
		 */
	}
}
