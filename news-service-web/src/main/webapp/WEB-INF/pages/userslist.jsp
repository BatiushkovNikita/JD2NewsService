<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Roles</title>
    <%@ include file="include.jsp" %>
</head>
<body>
<%@ include file="frag/header.jsp" %>
<div class="container">
    <div class="container">
        <h2><spring:message code="users.list.title"/></h2>
        <table class="table table-hover">
            <thead>
            <tr>
                <th><spring:message code="users.list.id" /></th>
                <th><spring:message code="users.list.email" /></th>
                <th><spring:message code="users.list.first.name" /></th>
                <th><spring:message code="users.list.last.name" /></th>
                <th><spring:message code="users.list.cellphone" /></th>
                <th><spring:message code="users.list.roles" /></th>
            </tr>
            </thead>
            <c:forEach items="${usersList}" var="user">
            <tbody>
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.cellPhone}</td>
                <td>
                    <c:forEach items="${user.roles}" var="role">
                        ${role.roleName}
                    </c:forEach>
                </td>
            </tr>
            </tbody>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>