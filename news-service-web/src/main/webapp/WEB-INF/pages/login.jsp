<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ include file="include.jsp"%>

<html>
<head>
    <title>Login page</title>
    <%@ include file="include.jsp"%>
</head>
<body>
    <div class="container">
        <h1><fmt:message key="login.title"/></h1>
        <h2><fmt:message key="login.sign.in"/></h2>
        <form class="form-horizontal" role="form" action="Controller" method="post">
            <input type=hidden name="command" value="login">

            <div class="form-group">
                <label class="control-label col-sm-2" for="email"><fmt:message key="login.email"/></label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="pwd"><fmt:message key="login.password"/></label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="pwd" name="password" placeholder="Enter password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <span style="color: #ff0000; ">${errorLoginInput}</span>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <fmt:message var="submitButton" key="login.button.sign.in"/>
                    <button type="submit" class="btn btn-primary">${submitButton}</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
