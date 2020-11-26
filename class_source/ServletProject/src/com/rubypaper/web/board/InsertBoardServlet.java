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
//		// web.xml 파일에 설정된 로컬 파라미터 정보 추출
//		encoding = config.getInitParameter("boardEncoding");
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 글로벌 파라미터 정보 추출
//		ServletContext context = getServletContext();
//		encoding = context.getInitParameter("boardEncoding");
		
		// 1. 사용자 입력정보 추출
//		request.setCharacterEncoding(encoding);
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		
		// 3. 화면 네비게이션
		response.sendRedirect("getBoardList.do");
	}

}
