<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>Fragment</title>
<%@ include file="include.jsp"%>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div>
					<ul class="nav navbar-nav">
						<li><a href="${pageContext.request.pathInfo}?command=edit_news"><fmt:message key="frag.news.manager.edit" /></a></li>
						<li><a href="${pageContext.request.pathInfo}?command=delete_news"><fmt:message key="frag.news.manager.delete" /></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</body>
</html>