<%@page import="com.rubypaper.biz.board.BoardDAO"%>
<%@page import="com.rubypaper.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
  <%
      	// 1. ����� �Է����� ����
                  //	request.setCharacterEncoding(encoding);
                  	String seq = request.getParameter("seq");
                  	
                  	// 2. DB ���� ó��
                  	BoardVO vo = new BoardVO();
                  	vo.setSeq(Integer.parseInt(seq));
                  	
                  	BoardDAO boardDAO = new BoardDAO();
                  	boardDAO.deleteBoard(vo);
                  	
                  	// 3. ȭ�� �׺���̼�
                  	response.sendRedirect("getBoardList.jsp");
      %>