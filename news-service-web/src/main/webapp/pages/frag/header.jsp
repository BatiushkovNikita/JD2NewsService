<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>News feed page</title>
    <%@ include file="../include.jsp" %>
</head>
<body>
<%@ include file="../include.jsp" %>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">News-service</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li><a href='<spring:url value="/newsfeed" htmlEscape="true"/>'><fmt:message
                            key="frag.header.news"/></a></li>
                    <li><a href='<spring:url value="/addnews" htmlEscape="true"/>'><fmt:message
                            key="frag.header.add.news"/></a></li>
                    <li><a href='<spring:url value="${param.emptymystbe}" htmlEscape="true"/>'><fmt:message
                            key="frag.header.roles"/></a></li>
                    <li><a href='<spring:url value="/profile" htmlEscape="true"/>'><fmt:message
                            key="frag.header.profile"/></a></li>
                    <li><a href='<spring:url value="/logout" htmlEscape="true"/>'><fmt:message
                            key="frag.header.logout"/></a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<http auto-config="true" use-expressions="true">

    <intercept-url access="hasRole('user')" var="123" >dsdsds</intercept-url>

    <intercept-url access="hasRole('admin')">admindndnndndn</intercept-url>

    <sec:authentication var="principal" property="principal"/>

    <sec:authorize access="hasRole('user')" var="user"/>
    <p>${user}</p>


    <sec:authorize access="hasAnyRole('user')" var="user2"/>
    <p>${user2}</p>


    <sec:authorize access="hasRole('admin')" var="admin"/>
    <p>${admin}</p>


    <sec:authorize access="hasAnyRole('admin2')" var="admin2"/>
    <p>${admin2}</p>
</http>


<%--<c:if test="${!acc}">
    <span>USER see it</span>
</c:if>--%>

<%--    <sec:authorize url="editnews.jsp" access="h">
        <c:url value="editnews.jsp" var="accountUrl"/>
<li><a href="${accountUrl}">My Account</a></li>
</sec:authorize>--%>

<%--<sec:authorize access="hasRole('user')" var="isUser" />
<c:if test="${isUser}">
    <span>Only USER can see it</span>
</c:if>--%>


</body>
</html>