<%@page import="com.rubypaper.biz.board.BoardDAO"%>
<%@page import="com.rubypaper.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
  <%
      	// 1. ����� �Է����� ����
                  //	request.setCharacterEncoding(encoding);
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
                  	response.sendRedirect("getBoardList.jsp");
      %>