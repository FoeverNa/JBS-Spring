<%@page import="com.rubypaper.biz.user.UserDAO"%>
<%@page import="com.rubypaper.biz.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
    	// 1. 사용자 입력정보 추출
    		String id = request.getParameter("id");
    		String password = request.getParameter("password");
    	// 2. DB 연동 처리
    	UserVO vo = new UserVO();
    	vo.setId(id);
    	vo.setPassword(password);
    	
    	UserDAO userDAO = new UserDAO();
    	UserVO user = userDAO.getUser(vo);
    	
    	// 3. 화면 네비게이션
    	if(user != null) {
    		//로그인 성공 시, 세션에 상태정보를 저장한다.
    		session.setAttribute("user", user);
    		response.sendRedirect("getBoardList.jsp"); 
    	} else {
    		response.sendRedirect("login.html");
    	}
    %>    
    
<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
<h1><font color="green"><%=user.getName() %></font>님 환영합니다.</h1>
</center>
</body>
</html> --%>