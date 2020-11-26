package com.rubypaper.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.user.UserDAO;
import com.rubypaper.biz.user.UserVO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public LoginServlet() {
		System.out.println("===> LoginServlet 생성");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 입력정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리(by DAO, VO)
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		// 3. 화면 네비게이션
		if(user != null) {
			// 로그인 성공시에 세션에 상태정보를 저장한다.
			// 세선에 저장된 상태정보는 브라우저가 종료되기 전까지 유효하다
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10);
			session.setAttribute("user", user);
			System.out.println("로그인성공");
			
			// 로그인 성공시 글 목록 화면으로 바로 이동
			response.sendRedirect("getBoardList.do");
			
//			// 로그인 성공한 경우, 브라우저에 성공 메시지 전송
//			response.setContentType("text/html; charset=EUC-KR");
//			PrintWriter out = response.getWriter();
//			out.println("<h1>" + user.getName() + "님 로그인 성공 (Browser)</h1>");
//			out.println("<h1><a href='getBoardList.do'>글 목록 화면으로 이동</h1>");
//			out.println("<h1><a href='insertBoard.html'>글 등록 화면으로 이동</h1>");
		} else {
			// 로그인 실패한 경우, 다시 로그인 화면으로 이동
			response.sendRedirect("login.html");
		}
	}

}







