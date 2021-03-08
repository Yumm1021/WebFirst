<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// get 방식으로 서버에게 자료 보내기
	
	// http://localhost:9080/scriptlet_3.jsp?n1=10&n2=20
	String strN1 = request.getParameter("n1"); //통신할 때는 무조건 string
	String strN2 = request.getParameter("n2"); // request > 내장 객체 , 우리가 이 메서드를 만들 때 파라미터로 받아서 하는 방법도 있음
		// request는 무조건 .getParameter , 그리고 무조건 값이 넘어가는 건 value, 무조건 값은 String으로 줘야함

	int n1 = Integer.parseInt(strN1);
	int n2 = Integer.parseInt(strN2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div><%=strN1%>+<%=strN2%>=<%=n1+n2 %></div>
</body>
</html>