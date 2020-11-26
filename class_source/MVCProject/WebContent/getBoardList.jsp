<%-- <%@page import="com.rubypaper.biz.user.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="com.rubypaper.biz.board.BoardVO"%>
<%@page import="com.rubypaper.biz.board.BoardDAO"%>
<%@page contentType="text/html; charset=EUC-KR"%>
    
<%
	// 0. ������ ��ϵ� ���� ������
	UserVO user = (UserVO) session.getAttribute("user");
	List<BoardVO> boardList = (List) session.getAttribute("boardList");
	

	// 2. ���� ȭ�� ����
%> --%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 
	EL(Expression Language) �̶�?
	JSP ���Ͽ��� request�� session(���� ��ü)�� ����� �����͸� �����ϱ� ���� ǥ����
		JSP���� �ڹ��ڵ带 �Ϻ��� ���ִ� ���	
		
	JSTL(JSP Standard Tag Library) �̶�?
	JSP ���Ͽ��� if, for, switch ��� ���� �ڹ� �ڵ带 ��ü�ϴ� ǥ�� �±�
	
 -->


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>
<title>�� ���</title>
</head>
<body>
	<center>
		<h1>�Խñ� ���</h1>
		<h3>
			<font color='red'>%{user.name}</font>�� �α��� ȯ���մϴ�...... <a
				href='logout.do'>Log-out</a>
		</h3>
		<!-- �˻� ���� -->
		<form action='getBoardList.jsp' method='post'>
			<table border='1' cellpadding='0' cellspacing='0' width='700'>
				<tr>
					<td align='right'><select name='searchCondition'>
							<option value='TITLE'>����
							<option value='CONTENT'>����
					</select> <input name='searchKeyword' type='text' /> <input type='submit'
						value='�˻�' /></td>
				</tr>
			</table>
		</form>
		<!-- �˻� ���� -->
		<table border='1' cellpadding='0' cellspacing='0' width='700'>
			<tr>
				<th bgcolor='orange' width='100'>��ȣ</th>
				<th bgcolor='orange' width='200'>����</th>
				<th bgcolor='orange' width='150'>�ۼ���</th>
				<th bgcolor='orange' width='150'>�����</th>
				<th bgcolor='orange' width='100'>��ȸ��</th>
			</tr>

			<%-- <% for(BoardVO board : boardList){%>
 --%>
 
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.seq}></td>
					<td align='left'><a href='getBoard.do?seq=${board.seq} '>${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.regDate}</td>
					<td>${board.cnt}</td>
				</tr>
				<%-- <% } %> --%>
			</c:forEach>
		</table>
		<br> <a href='insertBoard.html'>���� ���</a>
	</center>
</body>
</html>
