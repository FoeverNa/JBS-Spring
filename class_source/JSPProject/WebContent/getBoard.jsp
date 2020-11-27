<%@page import="com.rubypaper.biz.user.UserVO"%>
<%@page import="com.rubypaper.biz.board.BoardDAO"%>
<%@page import="com.rubypaper.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	// 0. 세선에 등록된 정보 꺼내기
	UserVO user = (UserVO) session.getAttribute("user");

	// 1. 사용자 입력정보 추출
	String seq = request.getParameter("seq");
	
	// 2. DB 연동 처리
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	BoardVO board = boardDAO.getBoard(vo);
	
	// 3. 응답 화면 구성
%>

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>
<title>글 상세</title>
</head>
<body>
<center>
<h1>글 상세</h1>
<h3><a href='logout_proc.jsp'>Log-out</a></h3>
<hr>
<form action='updateBoard_proc.jsp' method='post'>
<input type='hidden' name='seq' value='<%= board.getSeq() %>'/>
<table border='1' cellpadding='0' cellspacing='0'>
<tr>
<td bgcolor='orange' width='70'>제목</td>
<td align='left'><input name='title' type='text' value='<%= board.getTitle() %>'/></td>
</tr>
<tr>
<td bgcolor='orange'>작성자</td>
<td align='left'><%= board.getWriter() %></td>
</tr>
<tr>
<td bgcolor='orange'>내용</td>
<td align='left'><textarea name='content' cols='40' rows='10'><%= board.getContent() %></textarea></td>
</tr>
<tr>
<td bgcolor='orange'>등록일</td>
<td align='left'><%= board.getRegDate() %></td>
</tr>
<tr>
<td bgcolor='orange'>조회수</td>
<td align='left'><%= board.getCnt() %></td>
</tr>
<tr>
<td colspan='2' align='center'>
<input type='submit' value='글 수정'/>
</td>
</tr>
</table>
</form>
<hr>
<a href='insertBoard.html'>글등록</a>&nbsp;&nbsp;&nbsp;
<%if(user.getRole().equals("ADMIN")) { %>
<a href='deleteBoard_proc.jsp?seq=<%= board.getSeq()%>'>글삭제</a>&nbsp;&nbsp;&nbsp;
		
<% } %>
<a href='getBoardList.jsp'>글목록</a>
</center>
</body>
</html>
