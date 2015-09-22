<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>Login page</title>
<%@ include file="include.jsp"%>
</head>
<body>
	<div class="container">
		<h1>
			<fmt:message key="login.title" />
		</h1>
		<h2>
			<fmt:message key="login.sign.in" />
		</h2>

		<form class="form-horizontal" role="form" action="/news-service/Controller" method="post">
			<input type=hidden name="command" value="login">

			<div class="form-group">
				<label class="control-label col-sm-2" for="email"><fmt:message key="login.email" /></label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email" name="email"
						placeholder="<fmt:message key="login.email.placeholder" />">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd"><fmt:message key="login.password" /></label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd" name="password"
						placeholder="<fmt:message key="login.password.placeholder" />">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
                    <c:if test="${param.error == 'invalidLoginPassword'}">
              <%--          <span style="color: #ff0000;">${errorLoginInput}</span>--%>
                        <span style="color: #ff0000;"> Try again baby eeee</span>
                    </c:if>
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

        <p>user@user:user:user</p><br>
        <p>root@root:root:admin</p>
	</div>


</body>
</html>