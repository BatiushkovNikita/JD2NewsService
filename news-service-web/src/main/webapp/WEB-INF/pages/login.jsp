<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Login page</title>
    <%@ include file="include.jsp" %>
</head>
<body>
<div class="container">
    <span style="float: right">
         <a href="?mylocale=en">EN</a> | <a href="?mylocale=ru">RU</a>
    </span>
    <h1><fmt:message key="login.title"/></h1>
    <h2><fmt:message key="login.sign.in"/></h2>
    <c:url var="loginUrl" value="/j_spring_security_check"/>
    <form class="form-horizontal" role="form" action="${loginUrl}" method="post">

        <div class="form-group">
            <label class="control-label col-sm-2" for="username"><fmt:message key="login.email"/></label>

            <div class="col-sm-10">
                <input type="email" class="form-control" id="username" name="j_username"
                       placeholder="<fmt:message key="login.email.placeholder" />">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="pwd"><fmt:message key="login.password"/></label>

            <div class="col-sm-10">
                <input type="password" class="form-control" id="pwd" name="j_password"
                       placeholder="<fmt:message key="login.password.placeholder" />">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:if test="${param.error != null}">
                    <span style="color: #ff0000;"><fmt:message key="error.registration.input.message"/></span>
                </c:if>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <fmt:message var="submitButton" key="login.button.sign.in"/>
                <button name="submit" type="submit" class="btn btn-success">${submitButton}</button>
            </div>
        </div>
    </form>

    <div class="form-horizontal" role="form">
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <fmt:message var="submitButton" key="login.button.registration"/>
                <a href='<spring:url value="/registration" htmlEscape="true"/>'>
                    <button type="button" class="btn btn-primary">${submitButton}</button>
                </a>
            </div>
        </div>
    </div>
    <br>

    <p>user@user:user: USER</p>
    <br>

    <p>root@root:root: ADMIN</p>
    <br>

    <p>moder@moder:moder123 MODERATOR</p>
</div>


</body>
</html>