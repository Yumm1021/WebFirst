<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "홍길동"); // request에 getParameter(쿼리스트링에서 값 가져올 때) > 개인
	//내장객체 중에 set, get Attribute가 있는 친구가 4개 있음
	//pageContext, request, session, application 이 순서대로 뜸 > 차례로 있냐고 물어보고 없으면 다음 다음 다음
	pageContext.setAttribute("name", "지윤이"); // 개인
	session.setAttribute("name", "햄버거"); // 개인
	application.setAttribute("name", "닭발"); // application 은 공용 
	
//	String name = "djdkdk"; 이렇게 하면 표현식으로만 쓸 수 있음 el식 사용 불가	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>${param.n1} + ${param.n2} = ${paran.n1}${param.n2}</div> <!-- $ 쓰는게 el식이라고 함 -->
	<!-- param. 은 주소에 박혀있는 것만 가져올 수 있음 (쿼리스트링) -->
	<div>${name}</div> <!-- 제일 먼저 pageContext에 물어보고 있으면 그걸 쓰고 나머지는 안 물어봄 -->
	<!-- 내장객체에 박혀있는 key값만 가져올 수 있음 param. 이렇게 안 쓰면  -->
</body>
</html>