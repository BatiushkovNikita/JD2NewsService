<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>News feed</title>
    <%@ include file="include.jsp" %>
</head>
<body>
<%@ include file="frag/header.jsp" %>
<div class="container">
    <h2><spring:message code="newsfeed.title"/></h2>
    <c:forEach items="${newsFeed}" var="newses">
        <div class="panel-group">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b>${newses.topic}</b><br>
                    <h6><i>${newses.publicationDate}</i></h6>
                </div>
                <div class="panel-body">${newses.newsText}</div>
                <div class="panel-footer">
                    <h6>
                        <spring:message code="newsfeed.author"/>: ${newses.authorFirsName} ${newses.authorLastName}<br>
                        <spring:message code="newsfeed.tags"/>:
                        <c:forEach items="${newses.tagsVO}" var="tags">
                            <spring:url value="{tagName}/newsfeed" var="newsesByTag">
                                <spring:param name="tagName" value="${tags.tagName}"/>
                            </spring:url>
                            <a href="${fn:escapeXml(newsesByTag)}">${tags.tagName}</a>
                        </c:forEach>
                    </h6>
                    <sec:authorize access="hasAnyRole('admin','moderator')">
                        <p>
                            <spring:url value="{newsId}/edit" var="editNewsUrl">
                                <spring:param name="newsId" value="${newses.id}"/>
                            </spring:url>
                            <a href="${fn:escapeXml(editNewsUrl)}" class="btn btn-default btn-xs">
                                <spring:message code="newsfeed.edit.news"/></a>

                            <spring:url value="{newsId}/delete" var="deleteNewsUrl">
                                <spring:param name="newsId" value="${newses.id}"/>
                            </spring:url>
                            <a href="${fn:escapeXml(deleteNewsUrl)}" class="btn btn-danger btn-xs">
                                <spring:message code="newsfeed.delete.news"/></a>
                        </p>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>