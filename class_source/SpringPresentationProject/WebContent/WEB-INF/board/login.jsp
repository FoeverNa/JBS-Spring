<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><spring:message code="user.login.mainTitle"/></title>
</head>
<body>
<center>
<h1><spring:message code="user.login.mainTitle"/></h1>
<a href="login.do?lang=ko"><spring:message code="user.login.langLink.ko"/></a>&nbsp;&nbsp;&nbsp;
<a href="login.do?lang=en"><spring:message code="user.login.langLink.en"/></a>

<hr>
<form action="login.do" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="300">
<tr>
	<td bgcolor="orange"><spring:message code="user.login.id"/></td>
	<td><input type="text" name="id" size="10" value="${userVO.id}"/></td>
</tr>
<tr>
	<td bgcolor="orange"><spring:message code="user.login.password"/></td>
	<td><input type="password" name="password" size="10" value="${userVO.password }"/></td>
</tr>
<tr>
	<td colspan="2" align="center"><input type="submit" value="<spring:message code="user.login.loginBtn"/>"/></td>
</tr>
</table>
</form>
</center>
</body>
</html>
