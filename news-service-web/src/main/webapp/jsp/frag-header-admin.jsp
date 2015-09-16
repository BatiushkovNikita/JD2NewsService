<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>News feed page</title>
<title>Bootstrap Case</title>
<%@ include file="include.jsp"%>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">News-service</a>
				</div>
				<div>
					<ul class="nav navbar-nav">
						<%-- <li><a href="http://localhost:8085/news-service-web/Controller?command=news_feed"><fmt:message key="frag.header.news" /></a></li> --%>
						<li><a href="${pageContext.request.pathInfo}?command=news_feed"><fmt:message key="frag.header.news" /></a></li>
						<li><a href="${pageContext.request.pathInfo}?command=manage_news"><fmt:message key="frag.header.add.news" /></a></li>
						
						<li><a href="${pageContext.request.pathInfo}?command=roles"><fmt:message key="frag.header.roles" /></a></li>
						<li><a href="${pageContext.request.pathInfo}?command=profile"><fmt:message key="frag.header.profile" /></a></li>
						<li><a href="${pageContext.request.pathInfo}?command=logout"><fmt:message key="frag.header.logout" /></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</body>
</html>