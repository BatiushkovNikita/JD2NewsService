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
                <h1>Oops!</h1>
                <h2>Status: ${status}</h2>

                <div class="error-details">
                    The page <b>${errorUri}</b> you are looking cannot be represented.
                </div>
                <br>
                <div class="error-actions">
                    <a href='<spring:url value="/newsfeed" htmlEscape="true"/>' class="btn btn-primary btn-lg">
                        <span class="glyphicon glyphicon-home"></span>Back to news
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
