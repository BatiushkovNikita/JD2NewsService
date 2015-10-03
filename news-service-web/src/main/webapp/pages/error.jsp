<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <%@ include file="include.jsp" %>
</head>
<body>

error.jsp

<h1>Error : ${openException.message}</h1>
<c:forEach items="${openException.stackTrace}" var="st">
    ${st}
</c:forEach>

</body>
</html>
