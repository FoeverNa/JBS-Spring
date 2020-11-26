package com.rubypaper.web.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;
import com.rubypaper.biz.user.UserVO;

public class GetBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetBoardListServlet() {	
		System.out.println("===> GetBoardListServlet ����");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. ����üũ
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		if (user.getId() == null) {
			response.sendRedirect("login.html");
		} else {

			//		// �۸�� ȭ���� ��û�� �������� ���ε� ���� ��ü�� ����.
			//		HttpSession session = request.getSession();
			//		if(session.isNew()) {
			//			System.out.println("===> GetBoardListServlet ó�� ������ �����̴�.");
			//		} else {
			//			System.out.println("---> ������ ������ ���� �����ϴ� ���̴�.");
			//		}

			// 1. ����� �Է����� ����(�˻� ����� ����...)

			//		request.setCharacterEncoding("EUC-KR");
			String searchCondition = request.getParameter("serachCondition");
			String searchKeyword = request.getParameter("searchKeyword");

			// Null check
			if (searchCondition == null)
				searchCondition = "TITLE";
			if (searchKeyword == null)
				searchKeyword = "";

			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSerachCondition(searchCondition);
			vo.setSerchKeyword(searchKeyword);

			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);

			// 3. ���� ȭ�� ����
			response.setContentType("text/html; charset=EUC-KR");
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>");
			out.println("<title>�� ���</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<center>");
			out.println("<h1>�Խñ� ���</h1>");
			out.println("<h3><font color='red'>" + user.getName() + "</font>�� �α��� ȯ���մϴ�......");
			out.println("<a href='logout.do'>Log-out</a></h3>");

			out.println("<!-- �˻� ���� -->");
			out.println("<form action='getBoardList.do' method='post'>");
			out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
			out.println("<tr>");
			out.println("<td align='right'>");
			out.println("<select name='searchCondition'>");
			out.println("<option value='TITLE'>����");
			out.println("<option value='CONTENT'>����");
			out.println("</select>");
			out.println("<input name='searchKeyword' type='text'/>");
			out.println("<input type='submit' value='�˻�'/>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</form>");
			out.println("<!-- �˻� ���� -->");

			out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
			out.println("<tr>");
			out.println("<th bgcolor='orange' width='100'>��ȣ</th>");
			out.println("<th bgcolor='orange' width='200'>����</th>");
			out.println("<th bgcolor='orange' width='150'>�ۼ���</th>");
			out.println("<th bgcolor='orange' width='150'>�����</th>");
			out.println("<th bgcolor='orange' width='100'>��ȸ��</th>");
			out.println("</tr>");

			for (BoardVO board : boardList) {
				out.println("<tr>");
				out.println("<td>" + board.getSeq() + "</td>");
				out.println("<td align='left'><a href='getBoard.do?seq=" + board.getSeq() + "'>" + board.getTitle() + "</a></td>");
				out.println("<td>" + board.getWriter() + "</td>");
				out.println("<td>" + board.getRegDate() + "</td>");
				out.println("<td>" + board.getCnt() + "</td>");
				out.println("</tr>");
			}

			out.println("</table>");
			out.println("<br>");
			out.println("<a href='insertBoard.html'>���� ���</a>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");

			out.close();
		}
	}

}
