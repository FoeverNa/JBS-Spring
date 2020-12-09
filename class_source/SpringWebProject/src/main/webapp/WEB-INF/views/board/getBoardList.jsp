<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- 
	EL(Expression Language) �̶�?
	JSP ���Ͽ��� request�� session(���� ��ü)�� ����� �����͸� �����ϱ� ���� ǥ����
	
	JSTL(JSP Standard Tag Library) �̶�?
	JSP ���Ͽ��� if, for, switch ��� ���� �ڹ� �ڵ带 ��ü�ϴ� JSP ǥ�� �±�
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
			<font color='red'>${user.name }</font>�߰��ؾ��Ѵ�<a
				href='logout.do'>Log-out</a>
		</h3>
		<!-- �˻� ���� -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
					<select name="searchCondition">
						<option value="TITLE" <c:if test="${search.searchCondition == 'TITLE'}">selected="selected"</c:if>>����</option>
						<option value="CONTENT" <c:if test="${search.searchCondition == 'CONTENT'}">selected="selected"</c:if>>����</option>
					</select> 
					<input name="searchKeyword" type="text" value="${search.searchKeyword }" />
					<input type="submit" value="�˻�" /></td>
				</tr>
			</table>
		</form>

		<!-- �˻� ���� -->
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
