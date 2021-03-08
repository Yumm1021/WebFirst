<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script defer src="/js/common.js"></script>
</head>
<body>
<div>
		<form id="frm" action="/modHobby" method="post" onsubmit="return hobbyChk();">
		<label>i_hobby : <input type="hidden" name="i_hobby" value="${param.i_hobby}" readonly></label> <!-- 값이 바뀌면 안되니까 readonly --> <!-- param이 붙으면 쿼리스트링에 있는 값을 가져옴 -->
		<label>취미명 : <input type="text" name="hobby" value="${data.nm}"></label>
		<input type="submit" value="수정">
		</form>
	</div>
</body>
</html>