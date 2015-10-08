<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Profile</title>
    <%@ include file="include.jsp" %>
</head>
<body>
<%@ include file="frag/header.jsp" %>
<div class="container">
    <h2><fmt:message key="profile.title"/></h2>
    <c:url value="/profile" var="saveUser"/>
    <form:form cssClass="form-horizontal" modelAttribute="userVOParam" action="${saveUser}" method="post">

        <%@ include file="frag/userdata.jsp" %>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <fmt:message var="submitButton" key="profile.button.save"/>
                <button type="submit" value="save" class="btn btn-success">${submitButton}</button>
            </div>
        </div>

    </form:form>
</div>
</body>
</html>