package com.rubypaper.web.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;

public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String encoding;
	
//	public void init(ServletConfig config) throws ServletException {
//		// web.xml ���Ͽ� ������ ���� �Ķ���� ���� ����
//		encoding = config.getInitParameter("boardEncoding");
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. �۷ι� �Ķ���� ���� ����
//		ServletContext context = getServletContext();
//		encoding = context.getInitParameter("boardEncoding");
		
		// 1. ����� �Է����� ����
//		request.setCharacterEncoding(encoding);
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		
		// 3. ȭ�� �׺���̼�
		response.sendRedirect("getBoardList.do");
	}

}
