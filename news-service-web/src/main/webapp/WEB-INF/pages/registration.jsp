<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Registration</title>
    <%@ include file="include.jsp" %>
</head>
<body>

<div class="container">
    <h1><fmt:message key="registration.title"/></h1>
    <h2><fmt:message key="registration.sign.up"/></h2>
    <c:url value="/registration" var="saveUser"/>
    <form:form cssClass="form-horizontal" modelAttribute="userVOParam" action="${saveUser}" method="post">

        <div class="form-group">
            <form:label class="control-label col-sm-2" path="email">
                <spring:message code="frag.userdata.email"/></form:label>
            <div class="col-sm-10">
                <span class="text-danger"><form:errors path="email"/></span>
                <spring:message code="frag.userdata.email.placeholder" var="placeholder"/>
                <form:input placeholder="${placeholder}" type="email" cssClass="form-control" id="email" path="email"/>
            </div>
        </div>

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