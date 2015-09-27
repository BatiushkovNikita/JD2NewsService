<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Sign up page</title>
    <%@ include file="include.jsp" %>
</head>
<body>


<div class="container">
    <h1>
        <fmt:message key="registration.title"/>
    </h1>

    <h2>
        <fmt:message key="registration.sign.up"/>
    </h2>
    <c:url value="/registration" var="saveUser" />
    <form:form modelAttribute="userAttribute" action="${saveUser}" method="post">
        <table>
            <tr>
                <td><form:label path="firstName">First Name:</form:label></td>
                <td><form:input path="firstName"/></td>
            </tr>

            <tr>
                <td><form:label path="lastName">Last Name</form:label></td>
                <td><form:input path="lastName"/></td>
            </tr>

            <tr>
                <td><form:label path="email">Email</form:label></td>
                <td><form:input path="email"/></td>
            </tr>

            <tr>
                <td><form:label path="password">Pass</form:label></td>
                <td><form:input path="password"/></td>
            </tr>

            <tr>
                <td><form:label path="cellPhone">CellPhone</form:label></td>
                <td><form:input path="cellPhone"/></td>
            </tr>
        </table>

        <input type="submit" value="Save"/>

    </form:form>
</div>


</body>
</html>