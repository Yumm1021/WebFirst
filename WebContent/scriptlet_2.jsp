<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	// 이 안에서는 메서드를 만들 수 없다 왜 ? 메서드 안에 있기 때문에 메서드 안에는 메서드를 만들 수 없다
			//스크립틀릿에 느낌표를 붙여주면 메서드를 만들 수 있다.
	int a = 10; // 전역변수에 준거		
	private int sum(int n1, int n2) {
		return n1 + n2;
}

%>

<%
	int a = 20; // 지역변수에 준거 , 하나의 메서드 안으로 들어감 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립틀릿2</title>
</head>
<body>
	<div><%=sum(10, 45) %></div>
	<div><%=a%></div>	<!-- 여기에 this.a를 써주면 객체화가 됨 , 이름이 같을 때 내가 멤버필드에 있는 변수를 쓰고 싶을 때는 this를 붙여주면 됨 -->
</body>
</html>