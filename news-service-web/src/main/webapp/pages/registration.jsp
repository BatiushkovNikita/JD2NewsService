<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Registration page</title>
    <%@ include file="include.jsp" %>
</head>
<body>


<div class="container">
    <h1>
        <fmt:message key="registration.title"/>
    </h1>

    <h2>
        <fmt:message key="registration.sign.up"/>
    </h2>
    <c:url value="/registration" var="saveUser"/>
    <form:form cssClass="form-horizontal" modelAttribute="userAttribute" action="${saveUser}" method="post">

        <%@ include file="frag/userdata.jsp" %>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <fmt:message var="submitButton" key="registration.button"/>
                <button type="submit" value="save" class="btn btn-success">${submitButton}</button>
            </div>
        </div>

    </form:form>
</div>
</body>
</html>