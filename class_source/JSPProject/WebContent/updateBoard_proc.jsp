<%@page import="com.rubypaper.biz.board.BoardDAO"%>
<%@page import="com.rubypaper.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
  <%
      	// 1. 사용자 입력정보 추출
                  //	request.setCharacterEncoding(encoding);
                  	String title = request.getParameter("title");
                  	String seq = request.getParameter("seq");
                  	String content = request.getParameter("content");
                  	
                  	// 2. DB 연동 처리
                  	BoardVO vo = new BoardVO();
                  	vo.setTitle(title);
                  	vo.setSeq(Integer.parseInt(seq));
                  	vo.setContent(content);
                  	
                  	BoardDAO boardDAO = new BoardDAO();
                  	boardDAO.updateBoard(vo);
                  	
                  	// 3. 화면 네비게이션
                  	response.sendRedirect("getBoardList.jsp");
      %>