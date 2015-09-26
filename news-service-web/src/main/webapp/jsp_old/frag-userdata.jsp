<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>Fragment</title>
<%@ include file="../pages/include.jsp"%>
</head>
<body>
<!-- 	<div class="container"> -->
<!-- 		<form class="form-horizontal" role="form" action="Controller" method="post">
			<input type=hidden name="command" value="registration"> -->

			<div class="form-group">
				<label class="control-label col-sm-2" for="firstName"><fmt:message key="frag.userdata.first.name" /></label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="firstName" name="firstName"
						placeholder="<fmt:message key="frag.userdata.first.name.placeholder"/>">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="lastName"><fmt:message key="frag.userdata.last.name" /></label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="lastName" name="lastName"
						placeholder="<fmt:message key="frag.userdata.last.name.placeholder"/>">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="email"><fmt:message key="frag.userdata.email" /></label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email" name="email"
						placeholder="<fmt:message key="frag.userdata.email.placeholder"/>">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="password"><fmt:message key="frag.userdata.password" /></label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password" name="password"
						placeholder="<fmt:message key="frag.userdata.password.placeholder"/>">
				</div>
			</div>

	<!-- 	</form> -->
<!-- 	</div> -->
</body>
</html>