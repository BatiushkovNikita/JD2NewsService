<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>Sign up page</title>
<%@ include file="../WEB-INF/jsp/include.jsp"%>
</head>
<body>
	<div class="container">
		<h1>
			<fmt:message key="registration.title" />
            <h3>${message}</h3>
		</h1>
		<h2>
			<fmt:message key="registration.sign.up" />
		</h2>

		<form class="form-horizontal" role="form" action="/news-service/Controller" method="post">
			<input type=hidden name="command" value="registration">
			
			<%@ include file="frag-userdata.jsp"%>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<span style="color: #ff0000;">${errorRegistrationInput}</span>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<fmt:message var="submitButton" key="registration.button" />
					<button type="submit" class="btn btn-success">${submitButton}</button>
				</div>
			</div>
			
		</form>
	</div>
</body>
</html>