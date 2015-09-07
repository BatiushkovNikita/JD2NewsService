<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>News feed</title>
    <%@ include file="include.jsp" %>
</head>
<body>
<%@ include file="frag-header-admin.jsp" %>
<form action="/news-service/Controller" method="post">
    <input type=hidden name="command" value="news_feed">

    <div class="container">
        <h2>
            <fmt:message key="newsfeed.title"/>
        </h2>

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
                    <div class="panel-body">Autor</div>
                </div>
                <%@ include file="frag-news-manage.jsp" %>
            </div>
        </c:forEach>

    </div>

</form>
</body>
</html>