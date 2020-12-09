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
//        System.out.println("===> DispatcherServlet 생성");
//    }
//    
//    public void init() throws ServletException {
//		handlerMapping = new HandlerMapping();
//		viewResolver = new ViewResolver();
//		
//		// VeiewResolver의 접두사와 접미사를 설정한다.
//		viewResolver.setPrefix("./");
//		viewResolver.setSuffix(".jsp");
//    }
//
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("EUC-KR");
//		
//		// 1. 사용자 요청 path 정보를 추출한다.
//		String uri = request.getRequestURI();
//		String path = uri.substring(uri.lastIndexOf("/"));
//		System.out.println(path);
//		
//		// 2. HandlerMapping을 통해 path에 해당하는 Controller를 검색한다.
//		Controller ctrl = handlerMapping.getController(path);
//
//		// 3. 검색된 Controller를 실행한다.
//		String viewName = ctrl.handleRequest(request, response);
//		
//		// 4. ViewResolver를 통해 viewName에 해당하는 화면을 검색한다.
//		String view = null;
//		if (!viewName.contains(".do")) {
//			view = viewResolver.getView(viewName);
//		} else {
//			view = viewName;
//		}
//
//		// 5. ViewResolver가 검색해준 화면으로 이동한다.
//		response.sendRedirect(view);
//	}
//}
