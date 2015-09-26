<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>News feed page</title>
<%@ include file="../pages/include.jsp"%>
</head>
<body>
	<%@ include file="frag-header-admin.jsp"%>
	<form action="Controller" method="post">
		<%-- <ctg:info-role role="${role}"> --%>
		<input type=hidden name="command" value="edit_news">
		<div class="container">
			<h2>
				<fmt:message key="edit.news.title" />
			</h2>
			
			<%@ include file="frag-editnews.jsp"%>
			
			<div class="form-group">
				<div class="col-sm-10">
					<fmt:message var="submitButton" key="edit.news.button" />
					<button type="submit" class="btn btn-primary">${submitButton}</button>
				</div>
			</div>
		</div>

	</form>
</body>
</html>