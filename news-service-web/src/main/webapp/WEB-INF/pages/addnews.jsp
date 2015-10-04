<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>Add news page</title>
<%@ include file="include.jsp"%>
</head>
<body>
	<%@ include file="frag/header.jsp"%>
    <c:url value="/addnews" var="addNews"/>
    <form:form modelAttribute="newsAttribute" action="${addNews}" method="post">

		<div class="container">
			<h2>
				<fmt:message key="add.news.title" />
			</h2>
			
			<%@ include file="frag/newsdata.jsp"%>
			
			<div class="form-group">
				<div class="col-sm-10">
					<spring:message code="add.new.button" var="submitButton" />
					<button type="submit" class="btn btn-primary">${submitButton}</button>
				</div>
			</div>
		</div>

	</form:form>
</body>
</html>