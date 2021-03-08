<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // 자바 문법을 사용할 수 있는 부분  스크립틀릿
    int n1 = 10;
    int n2 = 20;
    int result = n1 + n2;
    String str = "하하하하";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div><% out.print(result); %></div> <!-- out.print 안에 있는 변수가 가진 값이 html에 박힌다 -->
	<div><% out.print(n1+n2); %></div>
	<div><%=n1+n2%></div>
	<div><%=result%></div>
	<div><%=str%></div>
</body>
</html>