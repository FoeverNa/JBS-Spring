package com.rubypaper.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그아웃을 요청한 브라우저와 매핑된 세션을 강제 종료한다.
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect("login.html");
	}

	
}
