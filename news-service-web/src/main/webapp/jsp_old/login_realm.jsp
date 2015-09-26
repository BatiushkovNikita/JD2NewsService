<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Login realm page</title>
    <%@ include file="../pages/include.jsp"%>
</head>
<body>
<div class="container">
    <h1>
        <fmt:message key="login.title" />
    </h1>
    <h2>
        <fmt:message key="login.sign.in" />
    </h2>

    <p>Введите логин и пароль для доступа к приложению</p>
    <form method="post" action="j_security_check">
        <input type="text" name="j_username"/> login
        <br/><br/>
        <input type="password" name="j_password"/> password
        <br/><br/>
        <input type="submit" value="войти"/>
        <input type="reset" value="Reset"/>
    </form>

    <form class="form-horizontal" role="form" action="j_security_check" method="post">

        <div class="form-group">
            <label class="control-label col-sm-2" for="j_username"><fmt:message key="login.email" /></label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="j_username" name="j_username"
                       placeholder="<fmt:message key="login.email.placeholder" />">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="j_password"><fmt:message key="login.password" /></label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="j_password" name="j_password"
                       placeholder="<fmt:message key="login.password.placeholder" />">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <span style="color: #ff0000;">${errorLoginInput}</span>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <fmt:message var="submitButton" key="login.button.sign.in" />
                <button type="submit" class="btn btn-success">${submitButton}</button>
            </div>
        </div>
    </form>

    <div class="form-horizontal" role="form">
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <fmt:message var="submitButton" key="login.button.registration" />
                <a href="${pageContext.request.pathInfo}jsp/registration.jsp">
                    <button type="button" class="btn btn-primary">${submitButton}</button>
                </a>
            </div>
        </div>
    </div>
</div>


</body>
</html>
