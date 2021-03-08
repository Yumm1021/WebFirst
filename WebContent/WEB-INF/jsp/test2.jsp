<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글등록</h1>
	<form action="/test2" method="post">
		<div><input type="text" name="title" placeholder="제목"></div>
		<div><textarea name="ctnt"></textarea></div>
		<div>
			<input type="submit" value="글등록">
			<input type="reset" value="다시작성">
		</div>
	</form>
</body>
</html>