<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>News feed</title>
    <%@ include file="include.jsp" %>
</head>
<body>
<%@ include file="frag/header.jsp" %>

<div class="container">
    <h2>
        <spring:message code="newsfeed.title"/>
    </h2>
    <c:forEach items="${newsFeed}" var="newses">
        <div class="panel-group">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b>${newses.topic}</b><br>
                    <h6>
                        <i>${newses.publicationDate}</i>
                    </h6>
                </div>
                <div class="panel-body">${newses.newsText}</div>
                <div class="panel-footer">
                    <h6>
                        <spring:message code="newsfeed.author"/>: ${newses.authorFirsName} ${newses.authorLastName}<br>
                        <spring:message code="newsfeed.tags"/>:
                        <c:forEach items="${newses.tagsVO}" var="tags">
                            <u>${tags.tagName}</u>
                        </c:forEach>
                    </h6>
                    <%@ include file="frag/news-actions.jsp" %>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</form>
</body>
</html>