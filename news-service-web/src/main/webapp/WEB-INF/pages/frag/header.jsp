<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">News-service</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li><a href='<spring:url value="/newsfeed" htmlEscape="true"/>'><fmt:message
                            key="frag.header.news"/></a></li>
                    <sec:authorize access="hasAnyRole('admin','moderator')">
                        <li><a href='<spring:url value="/addnews" htmlEscape="true"/>'><fmt:message
                                key="frag.header.add.news"/></a></li>
                    </sec:authorize>
                    <sec:authorize access="hasAnyRole('admin')">
                        <li><a href='<spring:url value="/userslist" htmlEscape="true"/>'><fmt:message
                                key="frag.header.roles"/></a></li>
                    </sec:authorize>
                    <li><a href='<spring:url value="/profile" htmlEscape="true"/>'><fmt:message
                            key="frag.header.profile"/></a></li>
                    <li><a href='<spring:url value="/logout" htmlEscape="true"/>'><fmt:message
                            key="frag.header.logout"/></a></li>
                </ul>
            </div>

            <p align="right">
                <a href="?mylocale=en">en</a> | <a href="?mylocale=ru">ru</a>
            </p>

            <sec:authorize access="isAuthenticated()" var="isAuth"/>
            <c:if test="${isAuth == true}">
                <sec:authentication property="principal.roles" var="roles"/>
                <p align="right"> Email:
                        <sec:authentication property="principal.username"/>
                <p align="right"> Roles:
                    <c:if test="${roles != null}">
                        <c:forEach items="${roles}" var="r">
                            ${r.roleName}
                        </c:forEach>
                    </c:if>
                </p>
            </c:if>
        </div>
    </nav>
</div>

