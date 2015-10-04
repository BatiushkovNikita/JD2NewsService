<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exception</title>
    <%@ include file="../include.jsp" %>
</head>
<body>
<%@ include file="../frag/header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h3>exception: ${exc}</h3>
                <br>
                <div class="error-actions">
                    <c:forEach items="${exc.stackTrace}" var="stackTrace">
                        <div class="error-details">
                                ${stackTrace}
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
