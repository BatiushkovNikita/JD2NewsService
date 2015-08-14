<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>News feed page</title>
<%@ include file="include.jsp"%>
</head>
<body>
	<form action="Controller" method="post">
		<input type=hidden name="command" value="news_feed">
		<div class="container">
			<h2>
				<fmt:message key="newsfeed.title" />
			</h2>


			<div class="form-group">
				<fmt:message var="addNewsButton" key="newsfeed.button.add.news" />
				<button type="submit" class="btn btn-primary">${addNewsButton}</button>
			</div>



			<c:forEach items="${newsFeed}" var="news">
				<div class="panel-group">
					<div class="panel panel-default">
						<div class="panel-heading">
							<b>${news.topic}</b><br>
							<h6>
								<i>${news.publicationDate}</i>
							</h6>
						</div>
						<div class="panel-body">${news.newsText}</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</form>
</body>
</html>