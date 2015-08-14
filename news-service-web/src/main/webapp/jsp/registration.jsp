<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>Sign up page</title>
<%@ include file="include.jsp"%>
</head>
<body>
	<div class="container">
		<h1>
			<fmt:message key="registration.title" />
		</h1>
		<h2>
			<fmt:message key="registration.sign.up" />
		</h2>
		<form class="form-horizontal" role="form" action="Controller" method="post">
			<input type=hidden name="command" value="registration">

			<div class="form-group">
				<label class="control-label col-sm-2" for="firstName"><fmt:message key="registration.first.name" /></label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="firstName" name="firstName"
						placeholder="<fmt:message key="registration.first.name.placeholder"/>">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="lastName"><fmt:message key="registration.last.name" /></label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="lastName" name="lastName"
						placeholder="<fmt:message key="registration.last.name.placeholder"/>">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="email"><fmt:message key="registration.email" /></label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email" name="email"
						placeholder="<fmt:message key="registration.email.placeholder"/>">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd"><fmt:message key="registration.password" /></label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd" name="password"
						placeholder="<fmt:message key="registration.password.placeholder"/>">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<span style="color: #ff0000;">${errorLoginInput}</span>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<fmt:message var="submitButton" key="registration.button.register" />
					<button type="submit" class="btn btn-success">${submitButton}</button>
				</div>
			</div>
			<h2>
				<fmt:message key="registration.already.registered" />
			</h2>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<fmt:message var="submitButton" key="registration.button.signin" />
					<button type="submit" class="btn btn-primary">${submitButton}</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>