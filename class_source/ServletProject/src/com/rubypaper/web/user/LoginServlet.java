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
		System.out.println("===> LoginServlet ����");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. ����� �Է����� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB ���� ó��(by DAO, VO)
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		// 3. ȭ�� �׺���̼�
		if(user != null) {
			// �α��� �����ÿ� ���ǿ� ���������� �����Ѵ�.
			// ������ ����� ���������� �������� ����Ǳ� ������ ��ȿ�ϴ�
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10);
			session.setAttribute("user", user);
			System.out.println("�α��μ���");
			
			// �α��� ������ �� ��� ȭ������ �ٷ� �̵�
			response.sendRedirect("getBoardList.do");
			
//			// �α��� ������ ���, �������� ���� �޽��� ����
//			response.setContentType("text/html; charset=EUC-KR");
//			PrintWriter out = response.getWriter();
//			out.println("<h1>" + user.getName() + "�� �α��� ���� (Browser)</h1>");
//			out.println("<h1><a href='getBoardList.do'>�� ��� ȭ������ �̵�</h1>");
//			out.println("<h1><a href='insertBoard.html'>�� ��� ȭ������ �̵�</h1>");
		} else {
			// �α��� ������ ���, �ٽ� �α��� ȭ������ �̵�
			response.sendRedirect("login.html");
		}
	}

}







