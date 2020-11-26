<%-- <%@page import="com.rubypaper.biz.user.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="com.rubypaper.biz.board.BoardVO"%>
<%@page import="com.rubypaper.biz.board.BoardDAO"%>
<%@page contentType="text/html; charset=EUC-KR"%>
    
<%
	// 0. 세선에 등록된 정보 꺼내기
	UserVO user = (UserVO) session.getAttribute("user");
	List<BoardVO> boardList = (List) session.getAttribute("boardList");
	

	// 2. 응답 화면 구성
%> --%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 
	EL(Expression Language) 이란?
	JSP 파일에서 request나 session(내장 객체)에 등록한 데이터를 접근하기 위한 표현식
		JSP에서 자바코드를 완벽히 없애는 방법	
		
	JSTL(JSP Standard Tag Library) 이란?
	JSP 파일에서 if, for, switch 등과 같은 자바 코드를 대체하는 표준 태그
	
 -->


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>
<title>글 목록</title>
</head>
<body>
	<center>
		<h1>게시글 목록</h1>
		<h3>
			<font color='red'>%{user.name}</font>님 로그인 환영합니다...... <a
				href='logout.do'>Log-out</a>
		</h3>
		<!-- 검색 시작 -->
		<form action='getBoardList.jsp' method='post'>
			<table border='1' cellpadding='0' cellspacing='0' width='700'>
				<tr>
					<td align='right'><select name='searchCondition'>
							<option value='TITLE'>제목
							<option value='CONTENT'>내용
					</select> <input name='searchKeyword' type='text' /> <input type='submit'
						value='검색' /></td>
				</tr>
			</table>
		</form>
		<!-- 검색 종료 -->
		<table border='1' cellpadding='0' cellspacing='0' width='700'>
			<tr>
				<th bgcolor='orange' width='100'>번호</th>
				<th bgcolor='orange' width='200'>제목</th>
				<th bgcolor='orange' width='150'>작성자</th>
				<th bgcolor='orange' width='150'>등록일</th>
				<th bgcolor='orange' width='100'>조회수</th>
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
		<br> <a href='insertBoard.html'>새글 등록</a>
	</center>
</body>
</html>
