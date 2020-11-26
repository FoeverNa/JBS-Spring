package com.rubypaper.web.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;
import com.rubypaper.biz.user.UserVO;

public class GetBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 사용자 입력정보 추출
		String seq = request.getParameter("seq");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		// 3. 응답 화면 구성
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>");
		out.println("<title>글 상세</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>글 상세</h1>");
		out.println("<a href='logout.do'>Log-out</a></h3>");
		out.println("<hr>");
		out.println("<form action='updateBoard.do' method='post'>");
		out.println("<input type='hidden' name='seq' value='" + board.getSeq() + "'/>");
		out.println("<table border='1' cellpadding='0' cellspacing='0'>");
		out.println("<tr>");
		out.println("<td bgcolor='orange' width='70'>제목</td>");
		out.println("<td align='left'><input name='title' type='text' value='" + board.getTitle() + "'/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td bgcolor='orange'>작성자</td>");
		out.println("<td align='left'>" + board.getWriter() + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td bgcolor='orange'>내용</td>");
		out.println("<td align='left'><textarea name='content' cols='40' rows='10'>" + board.getContent() + "</textarea></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td bgcolor='orange'>등록일</td>");
		out.println("<td align='left'>" + board.getRegDate() + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td bgcolor='orange'>조회수</td>");
		out.println("<td align='left'>" + board.getCnt() + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>");
		out.println("<input type='submit' value='글 수정'/>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<hr>");
		out.println("<a href='insertBoard.html'>글등록</a>&nbsp;&nbsp;&nbsp;");
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO)session.getAttribute("user");
		if(user.getRole().equals("ADMIN")) {
		out.println("<a href='deleteBoard.do?seq=" + board.getSeq() + "'>글삭제</a>&nbsp;&nbsp;&nbsp;");
		}

		out.println("<a href='getBoardList.do'>글목록</a>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

		
		out.close();
	}

}
