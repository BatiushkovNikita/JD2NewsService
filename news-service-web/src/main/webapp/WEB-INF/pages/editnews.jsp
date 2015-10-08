<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Edit news</title>
    <%@ include file="include.jsp" %>
</head>
<body>
<%@ include file="frag/header.jsp" %>
<div class="container">
    <h2><spring:message code="edit.news.title"/></h2>
    <c:url value="/editnews" var="editNews"/>
    <form:form modelAttribute="newsVOParam" action="${editNews}" method="post">

        <%@ include file="frag/newsdata.jsp" %>

        <div class="form-group">
            <div class="col-sm-10">
                <spring:message code="edit.news.button" var="submitButton"/>
                <button type="submit" class="btn btn-primary">${submitButton}</button>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>