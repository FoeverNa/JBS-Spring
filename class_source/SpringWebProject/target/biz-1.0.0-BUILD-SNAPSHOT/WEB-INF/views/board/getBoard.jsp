<%-- <%@page import="com.rubypaper.biz.user.UserVO"%>
<%@page import="com.rubypaper.biz.board.BoardDAO"%>
<%@page import="com.rubypaper.biz.board.BoardVO"%> --%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 
	EL(Expression Language) 이란?
	JSP 파일에서 request나 session(내장 객체)에 등록한 데이터를 접근하기 위한 표현식
		JSP에서 자바코드를 완벽히 없애는 방법	
		
	JSTL(JSP Standard Tag Library) 이란?
	JSP 파일에서 if, for, switch 등과 같은 자바 코드를 대체하는 표준 태그
	
 -->



<%-- 
<%
	// 0. 세선에 등록된 정보 꺼내기
	UserVO user = (UserVO) session.getAttribute("user");
	BoardVO board = (BoardVO) session.getAttribute("board");

	
	// 3. 응답 화면 구성	
%> --%>

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>
<title>글 상세</title>
</head>
<body>
<center>
<h1>글 상세</h1>
<h3><a href='logout_proc.do'>Log-out</a></h3>
<hr>
<form action='updateBoard.do' method='post'>
<input type='hidden' name='seq' value='${board.seq}'/>
<table border='1' cellpadding='0' cellspacing='0'>
<tr>
<td bgcolor='orange' width='70'>제목</td>
<td align='left'><input name='title' type='text' value='${board.title}'/></td>
</tr>
<tr>
<td bgcolor='orange'>작성자</td>
<td align='left'>${board.writer}</td>
</tr>
<tr>
<td bgcolor='orange'>내용</td>
<td align='left'><textarea name='content' cols='40' rows='10'>${board.content}</textarea></td>
</tr>
<tr>
<td bgcolor='orange'>등록일</td>
<td align='left'>${board.regDate}</td>
</tr>
<tr>
<td bgcolor='orange'>조회수</td>
<td align='left'>${board.cnt}</td>
</tr>
<tr>
<td colspan='2' align='center'>
<input type='submit' value='글 수정'/>
</td>
</tr>
</table>
</form>
<hr>
<a href='insertBoard.do'>글등록</a>&nbsp;&nbsp;&nbsp;
<%-- <%if(user.getRole().equals("ADMIN")) { %> --%>
<c:if test="${user.role == 'ADMIN'}">	
<%-- <% } %> --%>
<a href='deleteBoard.do?seq=${board.seq}'>글삭제</a>&nbsp;&nbsp;&nbsp;
</c:if>
<a href='getBoardList.do'>글목록</a>
</center>
</body>
</html>
