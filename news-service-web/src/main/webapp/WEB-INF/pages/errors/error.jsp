<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <%@ include file="../include.jsp" %>
</head>
<body>
<%@ include file="../frag/header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1><spring:message code="error.404.oops" /></h1>
                <h2><spring:message code="error.404.status" />: ${status}</h2>

                <div class="error-details">
                    <spring:message code="error.404.message" />
                </div>
                <br>
                <div class="error-actions">
                    <a href='<spring:url value="/newsfeed" htmlEscape="true"/>' class="btn btn-primary btn-lg">
                        <span class="glyphicon glyphicon-home"></span> <spring:message code="error.404.back" />
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
