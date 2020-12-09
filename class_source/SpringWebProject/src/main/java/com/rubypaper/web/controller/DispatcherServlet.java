//package com.rubypaper.web.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.rubypaper.biz.board.BoardDAOJDBC;
//import com.rubypaper.biz.board.BoardVO;
//import com.rubypaper.biz.user.UserDAOJDBC;
//import com.rubypaper.biz.user.UserVO;
//
//public class DispatcherServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	private HandlerMapping handlerMapping;
//	private ViewResolver viewResolver;
//       
//    public DispatcherServlet() {
//        System.out.println("===> DispatcherServlet ����");
//    }
//    
//    public void init() throws ServletException {
//		handlerMapping = new HandlerMapping();
//		viewResolver = new ViewResolver();
//		
//		// VeiewResolver�� ���λ�� ���̻縦 �����Ѵ�.
//		viewResolver.setPrefix("./");
//		viewResolver.setSuffix(".jsp");
//    }
//
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("EUC-KR");
//		
//		// 1. ����� ��û path ������ �����Ѵ�.
//		String uri = request.getRequestURI();
//		String path = uri.substring(uri.lastIndexOf("/"));
//		System.out.println(path);
//		
//		// 2. HandlerMapping�� ���� path�� �ش��ϴ� Controller�� �˻��Ѵ�.
//		Controller ctrl = handlerMapping.getController(path);
//
//		// 3. �˻��� Controller�� �����Ѵ�.
//		String viewName = ctrl.handleRequest(request, response);
//		
//		// 4. ViewResolver�� ���� viewName�� �ش��ϴ� ȭ���� �˻��Ѵ�.
//		String view = null;
//		if (!viewName.contains(".do")) {
//			view = viewResolver.getView(viewName);
//		} else {
//			view = viewName;
//		}
//
//		// 5. ViewResolver�� �˻����� ȭ������ �̵��Ѵ�.
//		response.sendRedirect(view);
//	}
//}
