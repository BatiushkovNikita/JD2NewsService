<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access denied</title>
    <%@ include file="../include.jsp" %>
</head>
<body>
<%@ include file="../frag/header.jsp" %>

<div class="container">
    <div class="row">
        <div class="center-block col-md-4">
            <div class="error-template">
                <h2><spring:message code="access.denied.message" /></h2>
                <br>
                <div class="error-actions">
                    <a href='<spring:url value="/newsfeed" htmlEscape="true"/>' class="btn btn-primary">
                        <spring:message code="access.denied.to.news" />
                    </a>
                </div>
                <br>
                <div class="error-actions">
                    <a href='<spring:url value="/login" htmlEscape="true"/>' class="btn btn-primary">
                        <spring:message code="access.denied.to.login" />
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
