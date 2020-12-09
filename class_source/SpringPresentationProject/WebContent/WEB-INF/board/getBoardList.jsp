<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- 
	EL(Expression Language) 이란?
	JSP 파일에서 request나 session(내장 객체)에 등록한 데이터를 접근하기 위한 표현식
	
	JSTL(JSP Standard Tag Library) 이란?
	JSP 파일에서 if, for, switch 등과 같은 자바 코드를 대체하는 JSP 표준 태그
-->

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>
<title><spring:message code="board.getBoardList.mainTitle"/></title>
</head>
<body>
	<center>
		<h1><spring:message code="board.getBoardList.title"/></h1>
		<h3>
			<font color='red'>${user.name }</font>추가해야한다<a
				href='logout.do'>Log-out</a>
		</h3>
		<!-- 검색 시작 -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
					<select name="searchCondition">
						<option value="TITLE" <c:if test="${search.searchCondition == 'TITLE'}">selected="selected"</c:if>>제목</option>
						<option value="CONTENT" <c:if test="${search.searchCondition == 'CONTENT'}">selected="selected"</c:if>>내용</option>
					</select> 
					<input name="searchKeyword" type="text" value="${search.searchKeyword }" />
					<input type="submit" value="검색" /></td>
				</tr>
			</table>
		</form>

		<!-- 검색 종료 -->
		<table border='1' cellpadding='0' cellspacing='0' width='700'>
			<tr>
				<th bgcolor='orange' width='100'><spring:message code="board.getBoardList.number"/></th>
				<th bgcolor='orange' width='200'><spring:message code="board.getBoardList.title"/></th>
				<th bgcolor='orange' width='150'><spring:message code="board.getBoardList.writer"/></th>
				<th bgcolor='orange' width='150'><spring:message code="board.getBoardList.regDate"/></th>
				<th bgcolor='orange' width='100'><spring:message code="board.getBoardList.cnt"/></th>
			</tr>

			<c:forEach var="board" items="${boardList }">
				<tr>
					<td>${board.seq }</td>
					<td align='left'><a href='getBoard.do?seq=${board.seq }'>${board.title }</a></td>
					<td>${board.writer }</td>
					<td>${board.regDate }</td>
					<td>${board.cnt }</td>
				</tr>
			</c:forEach>

		</table>
		<br> <a href='insertBoard.do'><spring:message code="board.getBoardList.newBoard"/></a>
		<br> <a href="getBoardList.do?lang=ko"><spring:message code="user.login.langLink.ko"/></a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do?lang=en"><spring:message code="user.login.langLink.en"/></a>
	</center>
</body>
</html>
