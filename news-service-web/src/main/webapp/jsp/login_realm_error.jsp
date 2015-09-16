<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login realm error</title>
    <%@ include file="include.jsp"%>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h2>
                    Login error. Try again.</h2>

                <div class="error-actions">
                    <a href="${pageContext.request.pathInfo}/news_service/index.jsp" class="btn btn-primary btn-lg"><span
                            class="glyphicon glyphicon-home"></span>
                        Back</a>
<%--
                    <a href="#{facesContext.externalContext.requestContextPath}" class="btn btn-primary btn-lg"><span
                            class="glyphicon glyphicon-home"></span>
                        Back</a>--%>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
