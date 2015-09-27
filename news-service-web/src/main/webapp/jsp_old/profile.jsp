<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>Profile</title>
<%@ include file="../pages/include.jsp"%>
</head>
<body>
	<%@ include file="../pages/frag/header-admin.jsp"%>
	<%-- <ctg:info-role role="${role}"> --%>
	<div class="container">
		<h2>
			<fmt:message key="profile.title" />
		</h2>
		<form class="form-horizontal" role="form" action="Controller" method="post">
			<input type=hidden name="command" value="profile">

			<%@ include file="frag-userdata.jsp"%>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<span style="color: #ff0000;">${errorLoginInput}</span>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<fmt:message var="submitButton" key="profile.button.save" />
					<button type="submit" class="btn btn-success">${submitButton}</button>
				</div>
			</div>
			<br>
		</form>
	

	</div>
</body>
</html>