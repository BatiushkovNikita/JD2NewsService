<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exception</title>
    <%@ include file="include.jsp" %>
</head>
<body>

exception.jsp

<h1>Error : ${exc.message}</h1>
<c:forEach items="${exc.stackTrace}" var="st">
    ${st}
</c:forEach>

</body>
</html>
