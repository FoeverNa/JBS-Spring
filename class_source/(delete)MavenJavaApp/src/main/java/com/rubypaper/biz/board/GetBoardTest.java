package com.rubypaper.biz.board;

public class GetBoardTest {

	public static void main(String[] args) {
		
		//1. �� ����ȸ ��� ó��
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		BoardVO board = boardDAO.getBoard(vo);
		
		System.out.println(board.getSeq() + "�� �Խ� ���� �� ����");
		System.out.println("���� : " + board.getTitle());
		System.out.println("�ۼ��� : " + board.getWriter());
		System.out.println("���� : " + board.getContent());
		System.out.println("����� : " + board.getRegDate());
		System.out.println("��ȸ�� : " + board.getCnt());

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
		 * // 5. �˻� ��� ó��(SELECT ������ ���Ͽ�...) if(rs.next()) {
		 * System.out.println("�Խ� �� �� ����"); System.out.println("��ȣ : " +
		 * rs.getInt("SEQ") + " : "); System.out.println("���� : " + rs.getString("TITLE")
		 * + " : "); System.out.println("�ۼ��� : " + rs.getString("WRITER") + " : ");
		 * System.out.println("���� : " + rs.getString("CONTENT") + " : ");
		 * System.out.println("����� : " + rs.getDate("REGDATE") + " : ");
		 * System.out.println("��ȸ�� : " + rs.getInt("CNT")); }
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); } finally { // close ����
		 * ResultSet -> Statement -> Connection try { if(rs != null) rs.close(); } catch
		 * (SQLException e1) { e1.printStackTrace(); } finally { rs = null; } try {
		 * if(stmt != null) { stmt.close(); } } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } finally { stmt = null; }
		 * try { if (conn != null && !conn.isClosed()) { conn.close(); } } catch
		 * (SQLException e) { e.printStackTrace(); } finally { conn = null; } }
		 */
	}
}
