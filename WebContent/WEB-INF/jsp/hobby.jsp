<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.util.List" %>
<%@ page import = "com.koreait.webfirst.HobbyEntity" %>
 <%
 	List<HobbyEntity> list = (List<HobbyEntity>)request.getAttribute("list");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hobby</title>
<script defer src="/js/common.js"></script>
</head>
<body>
	<h1>hobby</h1>
	<c:if test="${sessionScope.loginUser != null}"> <!-- 조건부 태그이며 표현식이 참인 경우에만 본문 내용을 표시 -->
	<div>
		<form id="frm" action="/hobby" method="post" onsubmit="return hobbyChk();">
		<label>취미명 : <input type="text" name="hobby"></label>
		<input type="submit" value="등록">
		</form>
	</div>
	</c:if>
	<table>
		<tr>
			<th>id</th>
			<th>취미명</th>
			<th></th>
		</tr>		
		<!-- 
	<% for(HobbyEntity vo : list) { %>
		<tr>
			<td><%=vo.getI_hobby()%></td>
			<td><%=vo.getNm()%></td>
			<td>
				<button onclick="chkDel(<%=vo.getI_hobby()%>);">삭제</button>
				<a href="/modHobby?i_hobby=<%=vo.getI_hobby()%>"><button>수정</button></a>
			</td>
	<% } %>
	 -->
	 
	<c:forEach begin="1" end="${requestScope.endIdx}" step="1" var="idx">
		${idx}
	</c:forEach>
	
	<c:forEach items="${requestScope.list}" var="item"> <!-- 내장객체 중 하나를 앞에 적어주면 훨씬 안정적임 > 딱 그걸 꼬집어서 꺼냄 -->
		<tr>
			<td>${item.i_hobby}</td>
			<td>${item.nm}</td>
			<td>
				<button onclick="chkDel(${item.i_hobby});">삭제</button>
				<a href="/modHobby?i_hobby=${item.i_hobby}%>"><button>수정</button></a>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>