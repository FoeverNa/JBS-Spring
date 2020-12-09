<%-- <%@page import="com.rubypaper.biz.user.UserVO"%>
<%@page import="com.rubypaper.biz.board.BoardDAO"%>
<%@page import="com.rubypaper.biz.board.BoardVO"%> --%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 
	EL(Expression Language) �̶�?
	JSP ���Ͽ��� request�� session(���� ��ü)�� ����� �����͸� �����ϱ� ���� ǥ����
		JSP���� �ڹ��ڵ带 �Ϻ��� ���ִ� ���	
		
	JSTL(JSP Standard Tag Library) �̶�?
	JSP ���Ͽ��� if, for, switch ��� ���� �ڹ� �ڵ带 ��ü�ϴ� ǥ�� �±�
	
 -->



<%-- 
<%
	// 0. ������ ��ϵ� ���� ������
	UserVO user = (UserVO) session.getAttribute("user");
	BoardVO board = (BoardVO) session.getAttribute("board");

	
	// 3. ���� ȭ�� ����	
%> --%>

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>
<title>�� ��</title>
</head>
<body>
<center>
<h1>�� ��</h1>
<h3><a href='logout_proc.do'>Log-out</a></h3>
<hr>
<form action='updateBoard.do' method='post'>
<input type='hidden' name='seq' value='${board.seq}'/>
<table border='1' cellpadding='0' cellspacing='0'>
<tr>
<td bgcolor='orange' width='70'>����</td>
<td align='left'><input name='title' type='text' value='${board.title}'/></td>
</tr>
<tr>
<td bgcolor='orange'>�ۼ���</td>
<td align='left'>${board.writer}</td>
</tr>
<tr>
<td bgcolor='orange'>����</td>
<td align='left'><textarea name='content' cols='40' rows='10'>${board.content}</textarea></td>
</tr>
<tr>
<td bgcolor='orange'>�����</td>
<td align='left'>${board.regDate}</td>
</tr>
<tr>
<td bgcolor='orange'>��ȸ��</td>
<td align='left'>${board.cnt}</td>
</tr>
<tr>
<td colspan='2' align='center'>
<input type='submit' value='�� ����'/>
</td>
</tr>
</table>
</form>
<hr>
<a href='insertBoard.do'>�۵��</a>&nbsp;&nbsp;&nbsp;
<%-- <%if(user.getRole().equals("ADMIN")) { %> --%>
<c:if test="${user.role == 'ADMIN'}">	
<%-- <% } %> --%>
<a href='deleteBoard.do?seq=${board.seq}'>�ۻ���</a>&nbsp;&nbsp;&nbsp;
</c:if>
<a href='getBoardList.do'>�۸��</a>
</center>
</body>
</html>
