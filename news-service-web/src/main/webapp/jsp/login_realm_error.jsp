<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404</title>
    <%@ include file="include.jsp"%>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h2>
                    Wrong input</h2>

                <div class="error-actions">
                    <a href="${pageContext.request.pathInfo}/news_service/jsp/login_realm.jsp" class="btn btn-primary btn-lg"><span
                            class="glyphicon glyphicon-home"></span>
                        Back</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
