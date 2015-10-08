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
                <h2>Not enough access rights</h2>
                <br>
                <div class="error-actions">
                    <a href='<spring:url value="/newsfeed" htmlEscape="true"/>' class="btn btn-primary">Back to news</a>
                </div>
                <div class="error-actions">
                    <a href='<spring:url value="/login" htmlEscape="true"/>' class="btn btn-primary">Log in as another user</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
