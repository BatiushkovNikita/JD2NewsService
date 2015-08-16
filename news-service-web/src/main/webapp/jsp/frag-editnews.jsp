<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>Fragment</title>
<%@ include file="include.jsp"%>
</head>
<body>
	<div class="container">
		<input type=hidden name="command" value="add_news">

		<div class="form-group">
			<label for="usr"><fmt:message key="frag.edit.news.topic" /></label> <input type="text" class="form-control" id="usr"
				name="topic">
		</div>

		<div class="form-group">
			<label for="comment"><fmt:message key="frag.edit.news.text" /></label>
			<textarea class="form-control" rows="5" id="comment" name="newsText"></textarea>
		</div>

		<div class="form-group">
			<span style="color: #ff0000;">${errorNewsInput}</span>
		</div>

	</div>
</body>
</html>